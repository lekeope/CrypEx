package io.edgedev.crypex;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.edgedev.crypex.databinding.CurrencyLayoutBinding;
import io.edgedev.crypex.remote.EtherService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EtherFragment extends Fragment {

    public static final String ETHER_KEY = "ether_key";
    private static final String TAG = "EtherFragment";
    private EtherFragmentListener mListener;
    private RecyclerView mRecyclerView;
    private EtherAdapter mEtherAdapter;
    private EtherService mService;
    private ProgressBar mProgressBar;
    private Button retryBtn;
    private List<Currency> list = new ArrayList<>();
    private TinyDB tinyDB;

    public EtherFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mService = ApiUtils.getEtherService();
        setHasOptionsMenu(true);
        tinyDB = new TinyDB(getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ethereum, container, false);
        mRecyclerView = view.findViewById(R.id.rv_btc);
        mProgressBar = view.findViewById(R.id.p_bar);
        retryBtn = view.findViewById(R.id.retry);
        retryBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                loadExchange();
            }
        });
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        mEtherAdapter = new EtherAdapter();
        mRecyclerView.setAdapter(mEtherAdapter);
        list = tinyDB.getListCurrency(ETHER_KEY);
        if (list.size() > 0) {
            mEtherAdapter.setList(list);
            mProgressBar.setVisibility(View.INVISIBLE);
            retryBtn.setVisibility(View.INVISIBLE);
        } else loadExchange();
        return view;
    }

    private void loadExchange() {
        retryBtn.setEnabled(false);
        mProgressBar.setVisibility(View.VISIBLE);
        mService.getCurrencies().enqueue(new Callback<EtherResponse>() {
            @Override
            public void onResponse(Call<EtherResponse> call, Response<EtherResponse> response) {
                mProgressBar.setVisibility(View.INVISIBLE);
                if (response.isSuccessful()) {
                    Log.d(TAG, "posts loaded from API");
                    list = response.body().getItems();
                    if (list == null) return;
                    mEtherAdapter.setList(list);
                    tinyDB.putListCurrency(ETHER_KEY, list);
                    mListener.syncSuccessful(new SimpleDateFormat("yyyy/MM/dd h:mm a").format(new Date()));
                    mListener.useSnackbar("posts loaded from API");
                    retryBtn.setVisibility(View.GONE);
                } else {
                    int statusCode = response.code();
                    if (mEtherAdapter.getItemCount() < 1)
                        retryBtn.setVisibility(View.VISIBLE);
                    mListener.useSnackbar("responeCode = " + statusCode);
                    Log.d(TAG, "responeCode = " + statusCode);
                    retryBtn.setVisibility(View.VISIBLE);
                    retryBtn.setEnabled(true);
                }
            }

            @Override
            public void onFailure(Call<EtherResponse> call, Throwable t) {
                mListener.useSnackbar(getString(R.string.network_error));
                Log.d(TAG, "error loading from API", t);
                mProgressBar.setVisibility(View.INVISIBLE);
                retryBtn.setVisibility(View.VISIBLE);
                retryBtn.setEnabled(true);
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mListener = (EtherFragmentListener) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public void refresh() {
        if (isAdded())
            loadExchange();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.main, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_refresh)
            refresh();
        return super.onOptionsItemSelected(item);
    }

    public interface EtherFragmentListener {
        void useSnackbar(String msg);

        void syncSuccessful(String date);

    }

    private class EtherAdapter extends RecyclerView.Adapter<EtherExchangeHolder> {

        private List<Currency> mList = new ArrayList<>();


        @Override
        public EtherExchangeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            CurrencyLayoutBinding binding = DataBindingUtil.inflate(inflater, R.layout.currency_layout, parent, false);
            return new EtherExchangeHolder(binding);
        }

        @Override
        public void onBindViewHolder(EtherExchangeHolder holder, int position) {
            holder.mBinding.setCrypto(mList.get(position));
        }

        @Override
        public int getItemCount() {
            return mList.size();
        }

        public void setList(List<Currency> list) {
            mList = list;
            notifyDataSetChanged();
        }
    }

    private class EtherExchangeHolder extends RecyclerView.ViewHolder {

        private CurrencyLayoutBinding mBinding;

        public EtherExchangeHolder(CurrencyLayoutBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }
    }
}
