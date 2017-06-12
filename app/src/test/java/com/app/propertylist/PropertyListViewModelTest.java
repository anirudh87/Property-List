package com.app.propertylist;

import android.support.annotation.NonNull;

import com.app.propertylist.datamodels.PropertyListResponse;
import com.app.propertylist.datamodels.SearchRequest;
import com.app.propertylist.network.PropertyService;
import com.app.propertylist.propertylist.PropertyListContract;
import com.app.propertylist.propertylist.PropertyListViewModel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.functions.Function;
import io.reactivex.internal.schedulers.ExecutorScheduler;
import io.reactivex.plugins.RxJavaPlugins;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PropertyListViewModelTest {

    @Mock
    PropertyService propertyService;

    @Mock
    PropertyListContract.View view;

    @Mock
    PropertyListContract.ViewModel viewModel;

    @BeforeClass
    public static void setUpRxSchedulers() {
        final Scheduler immediate = new Scheduler() {
            @Override
            public Scheduler.Worker createWorker() {
                return new ExecutorScheduler.ExecutorWorker(new Executor() {
                    @Override
                    public void execute(@NonNull Runnable runnable) {
                        runnable.run();
                    }
                });
            }
        };

        RxJavaPlugins.setInitIoSchedulerHandler(new Function<Callable<Scheduler>, Scheduler>() {
            @Override
            public Scheduler apply(Callable<Scheduler> scheduler) throws Exception {
                return immediate;
            }
        });
        RxJavaPlugins.setInitComputationSchedulerHandler(new Function<Callable<Scheduler>, Scheduler>() {
            @Override
            public Scheduler apply(Callable<Scheduler> scheduler) throws Exception {
                return immediate;
            }
        });
        RxJavaPlugins.setInitNewThreadSchedulerHandler(new Function<Callable<Scheduler>, Scheduler>() {
            @Override
            public Scheduler apply(Callable<Scheduler> scheduler) throws Exception {
                return immediate;
            }
        });
        RxJavaPlugins.setInitSingleSchedulerHandler(new Function<Callable<Scheduler>, Scheduler>() {
            @Override
            public Scheduler apply(Callable<Scheduler> scheduler) throws Exception {
                return immediate;
            }
        });
        RxAndroidPlugins.setInitMainThreadSchedulerHandler(new Function<Callable<Scheduler>, Scheduler>() {
            @Override
            public Scheduler apply(Callable<Scheduler> scheduler) throws Exception {
                return immediate;
            }
        });
    }

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getPropertyListTest() {

        PropertyListResponse propertyListResponse = new PropertyListResponse(null, null, null, null, null, null);

        SearchRequest request = new SearchRequest();
        request.setMode("buy");
        request.setSub("Bondi");
        request.setPcodes("2026");
        request.setState("NSW");

        when(propertyService.getPropertyList(request.getMode(), request.getSub(), request.getPcodes(), request.getState())).thenReturn(Observable.just(propertyListResponse));

        PropertyListViewModel propertyListViewModel = new PropertyListViewModel(propertyService, view);

        propertyListViewModel.loadProperties(request);

        verify(view, atLeastOnce()).onComplete();
    }
}
