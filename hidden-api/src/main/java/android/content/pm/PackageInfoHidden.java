package android.content.pm;

import dev.rikka.tools.refine.RefineAs;

/**
 * PackageInfo=packageManager.getPackageInfo(@NonNull String packageName, int flags);
 * </p>
 * PackageInfo=packageManager.getPackageInfo(@NonNull String packageName, PackageInfoFlags flags);
 */
@RefineAs(PackageInfo.class)
public class PackageInfoHidden {

  public String overlayTarget;

  public boolean isOverlayPackage() {
    throw new RuntimeException("Stub");
  }
}
