package org.fojut.sample.presentation.internal.di.module;

import android.content.Context;

import org.fojut.sample.domain.executor.PostExecutionThread;
import org.fojut.sample.domain.executor.ThreadExecutor;
import org.fojut.sample.presentation.executor.JobExecutor;
import org.fojut.sample.presentation.executor.UIThread;
import org.fojut.sample.presentation.view.application.BaseApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Dagger module that provides objects which will live during the application lifecycle.
 */
@Module
public class ApplicationModule {
    private final BaseApplication baseApplication;

    public ApplicationModule(BaseApplication baseApplication) {
        this.baseApplication = baseApplication;
    }

    @Provides @Singleton
    Context provideApplicationContext(){
        return baseApplication;
    }

    @Provides @Singleton
    ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor){
        return jobExecutor;
    }

    @Provides @Singleton
    PostExecutionThread providePostExecutionThread(UIThread uiThread) {
        return uiThread;
    }

}
