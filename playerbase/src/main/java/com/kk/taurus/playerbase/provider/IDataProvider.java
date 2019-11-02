package com.kk.taurus.playerbase.provider;

import android.os.Bundle;

import com.kk.taurus.playerbase.entity.DataSource;

/**
 * Time:2019/11/2
 * Author:RuYIng
 * Description:
 *
 * Data providers are designed for special needs.
 * For example, if you need to take a id to get the playback address,then play it.
 * In this case, the process can be independent of a data provider.
 *
 */
public interface IDataProvider {

    int PROVIDER_CODE_SUCCESS_MEDIA_DATA = -77001;

    int PROVIDER_CODE_DATA_PROVIDER_ERROR = -77003;

    void setOnProviderListener(OnProviderListener onProviderListener);

    /**
     * the provider handle data source, Users usually need to be implemented
     * @param sourceData sourceData
     */
    void handleSourceData(DataSource sourceData);

    /**
     * cancel the DataProvider handle data source.
     */
    void cancel();

    /**
     * destroy the provider.
     */
    void destroy();


    interface OnProviderListener{
        /**
         * on provider start load data
         */
        void onProviderDataStart();

        /**
         * on provider load data success
         * @param code code
         * @param bundle you can set some data to bundle
         */
        void onProviderDataSuccess(int code, Bundle bundle);

        /**
         * on provider load data error
         * @param code code
         * @param bundle bundle
         */
        void onProviderError(int code, Bundle bundle);
    }

}
