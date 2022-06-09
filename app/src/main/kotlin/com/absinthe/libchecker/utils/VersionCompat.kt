@file:Suppress("DEPRECATION")

package com.absinthe.libchecker.utils

import android.content.Context
import android.content.Intent
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.os.Parcelable
import com.absinthe.libchecker.R
import com.absinthe.libchecker.SystemServices
import java.io.Serializable

object VersionCompat {
  val MATCH_DISABLED_COMPONENTS = if (OsUtils.atLeastN()) {
    PackageManager.MATCH_DISABLED_COMPONENTS
  } else {
    PackageManager.GET_DISABLED_COMPONENTS
  }

  val MATCH_UNINSTALLED_PACKAGES = if (OsUtils.atLeastN()) {
    PackageManager.MATCH_UNINSTALLED_PACKAGES
  } else {
    PackageManager.GET_UNINSTALLED_PACKAGES
  }

  fun showCopiedOnClipboardToast(context: Context) {
    // See also: https://developer.android.com/about/versions/13/features/copy-paste
    if (!OsUtils.atLeastT()) {
      context.showToast(R.string.toast_copied_to_clipboard)
    }
  }

  fun getPackageInfo(packageName: String, flags: Int): PackageInfo {
    return if (OsUtils.atLeastT()) {
      SystemServices.packageManager.getPackageInfo(
        packageName,
        PackageManager.PackageInfoFlags.of(flags.toLong())
      )
    } else {
      SystemServices.packageManager.getPackageInfo(packageName, flags)
    }
  }

  fun getPackageArchiveInfo(archiveFilePath: String, flags: Int): PackageInfo? {
    return if (OsUtils.atLeastT()) {
      SystemServices.packageManager.getPackageArchiveInfo(
        archiveFilePath,
        PackageManager.PackageInfoFlags.of(flags.toLong())
      )
    } else {
      SystemServices.packageManager.getPackageArchiveInfo(archiveFilePath, flags)
    }
  }

  inline fun <reified T : Parcelable> getParcelableExtra(intent: Intent, name: String): T? {
    return if (OsUtils.atLeastT()) {
      intent.getParcelableExtra(name, T::class.java)
    } else {
      intent.getParcelableExtra(name)
    }
  }

  inline fun <reified T : Serializable> getSerializableExtra(intent: Intent, name: String): T? {
    return if (OsUtils.atLeastT()) {
      intent.getSerializableExtra(name, T::class.java)
    } else {
      intent.getSerializableExtra(name) as T?
    }
  }
}
