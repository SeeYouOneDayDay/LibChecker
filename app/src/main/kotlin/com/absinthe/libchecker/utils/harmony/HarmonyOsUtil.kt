package com.absinthe.libchecker.utils.harmony

/**
 * Created by su1216 on 21-6-28.
 */
object HarmonyOsUtil {

  private val _isHarmonyOs by lazy {
    runCatching {
      // "harmony".equals( Ref.call(null,"com.huawei.system.BuildEx","getOsBrand") as String?)
      val clz = Class.forName("com.huawei.system.BuildEx")
      val method = clz.getMethod("getOsBrand")
      // public static java.lang.String com.huawei.system.BuildEx.getOsBrand()
      // 静态方法反射对象为空
      "harmony".equals(method.invoke(null) as String?, ignoreCase = true)
    }.getOrDefault(false)
  }

  fun <T> wrapperStub(f: () -> T): T? {
    return try {
      f()
    } catch (e: Throwable) {
      null
    }
  }

  fun isHarmonyOs(): Boolean = _isHarmonyOs
}
