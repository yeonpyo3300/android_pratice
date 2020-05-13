package com.example.savemoneyproject;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class HistoryViewModel extends AndroidViewModel {

    private HistoryRepository mRepository;

    private LiveData<List<History>> mAllHistory;
    private LiveData<List<History>> mIncomeTotal;
    private LiveData<List<History>> mCostTotal;

    public HistoryViewModel(@NonNull Application application) {
        super(application);
        mRepository = new HistoryRepository(application);
        mAllHistory = mRepository.getAllHistory();
        mIncomeTotal = mRepository.getIncomeTotal();
        mCostTotal = mRepository.getCostTotal();
    }

    LiveData<List<History>> getAllHistory() {
        return mAllHistory;
    }

    LiveData<List<History>> getIncomeTotal() {
        return mIncomeTotal;
    }

    LiveData<List<History>> getCostTotal() {
        return mCostTotal;
    }


    public void insertHistory(History history) {
        mRepository.insertHistory(history);
    }

    public void deleteAll() {mRepository.deleteAll();}
}


