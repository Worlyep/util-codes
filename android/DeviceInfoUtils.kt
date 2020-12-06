import java.lang.ref.WeakReference
import java.util.*

object DeviceInfoUtils {
    var deviceName =  (android.os.Build.MODEL).toString()
    val deviceOS = (android.os.Build.VERSION.SDK_INT).toString()
    const val deviceType = "ANDROID"
    private lateinit var refDeviceUUID: WeakReference<String>

    fun getDeviceUUID(): String {
        val id = Pref.uuid

        lateinit var uuid: UUID
        if (id != null)
            uuid = UUID.fromString(id)
        else {
            uuid = UUID.randomUUID()
            Pref.uuid = uuid?.toString()
        }

        refDeviceUUID = WeakReference(uuid.toString())
        return refDeviceUUID.get().toString()
    }
}