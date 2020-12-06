import android.app.Activity
import android.content.Context
import android.content.Intent

@Suppress("CAST_NEVER_SUCCEEDS")
object IntentUtils {
    fun goDestination(context: Context, destination: Class<*>) {
        goIntentOrDestination(context, destination, null, false)
    }

    fun goDestination(context: Context, destination: Class<*>, isFinish: Boolean) {
        goIntentOrDestination(context, destination, null, isFinish)
    }

    fun goIntent(context: Context, intent: Intent) {
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                or Intent.FLAG_ACTIVITY_CLEAR_TOP
                or Intent.FLAG_ACTIVITY_SINGLE_TOP)
        goIntentOrDestination(context, null, intent, false)
    }

    fun goIntent(context: Context, intent: Intent, isFinish: Boolean) {
        goIntentOrDestination(context, null, intent, isFinish)
    }

    private fun goIntentOrDestination(context: Context?, destination: Class<*>?, intent: Intent?, isFinish: Boolean) {
        if (intent == null) {
            Intent(context, destination).apply {
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                        or Intent.FLAG_ACTIVITY_CLEAR_TOP
                        or Intent.FLAG_ACTIVITY_SINGLE_TOP)
                context?.startActivity(this)
            }
        } else context?.startActivity(intent)
        if (isFinish)
            (context as Activity).finish()
    }
}