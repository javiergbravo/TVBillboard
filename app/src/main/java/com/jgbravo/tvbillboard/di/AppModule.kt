package com.jgbravo.tvbillboard.di

import android.content.Context
import com.jgbravo.tvbillboard.data.datasource.DataSource
import com.jgbravo.tvbillboard.data.datasource.DataSourceImpl
import com.jgbravo.tvbillboard.data.service.BillboardService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRepository(
        @ApplicationContext appContext: Context
    ): BillboardService = BillboardService(appContext)

    @Singleton
    @Provides
    fun provideDataSource(
        dataSourceImpl: DataSourceImpl
    ): DataSource = dataSourceImpl

}