package com.github.drjacky.imagepicker.sample.util

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.browser.customtabs.CustomTabsIntent
import com.github.drjacky.imagepicker.R

/**
 * Intent Utility
 *
 * @author Dhaval Patel
 * @version 1.6
 * @since 05 January 2019
 */
object IntentUtil {

    /**
     * View Image in 3rd party apps
     *
     * @param activity Activity Instance
     * @param uri Image Uri
     *
     */
    fun showImage(activity: Activity, uri: Uri) {
        val intent = Intent(Intent.ACTION_VIEW)
        val authority =
            activity.packageName + activity.getString(R.string.image_picker_provider_authority_suffix)
//        val uri = FileProvider.getUriForFile(activity, authority, file)
        intent.setDataAndType(uri, "image/*")
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        activity.startActivity(intent)
    }

    /**
     * Open URL using chrome custom Tabs
     *
     * @param activity Activity Instance
     * @param url Valid http/https URL
     *
     */
    @JvmStatic
    fun openURL(activity: Activity, url: String) {
        val link = Uri.parse(url)
        CustomTabsIntent.Builder()
            .build()
            .launchUrl(activity, link)
    }
}