package android.content.pm;

import dev.rikka.tools.refine.RefineAs;

/**
 * @LongDef(flag = true, prefix = { "GET_", "MATCH_" }, value = {
 * GET_META_DATA,
 * GET_SHARED_LIBRARY_FILES,
 * MATCH_UNINSTALLED_PACKAGES,
 * MATCH_SYSTEM_ONLY,
 * MATCH_DEBUG_TRIAGED_MISSING,
 * MATCH_DISABLED_COMPONENTS,
 * MATCH_DISABLED_UNTIL_USED_COMPONENTS,
 * MATCH_INSTANT,
 * MATCH_STATIC_SHARED_AND_SDK_LIBRARIES,
 * GET_DISABLED_UNTIL_USED_COMPONENTS,
 * GET_UNINSTALLED_PACKAGES,
 * MATCH_HIDDEN_UNTIL_INSTALLED_COMPONENTS,
 * MATCH_APEX,
 * })
 * @Retention(RetentionPolicy.SOURCE) public @interface ApplicationInfoFlagsBits {}
 * <p>
 * packageManager.getApplicationInfo("com.androidlongs.contactsapplication", 0);
 */
@RefineAs(ApplicationInfo.class)
public class ApplicationInfoHidden {

  public static final int PRIVATE_FLAG_HIDDEN = 1;

  public String primaryCpuAbi;
  public int privateFlags;
}
