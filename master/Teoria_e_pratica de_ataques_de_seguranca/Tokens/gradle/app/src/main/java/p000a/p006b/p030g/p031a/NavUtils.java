package p000a.p006b.p030g.p031a;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import com.j256.ormlite.logger.Logger;

/* renamed from: a.b.g.a.w */
/* loaded from: classes.dex */
public final class NavUtils {
    /* renamed from: a */
    public static void m10074a(Activity activity, Intent intent) {
        if (Build.VERSION.SDK_INT >= 16) {
            activity.navigateUpTo(intent);
            return;
        }
        intent.addFlags(67108864);
        activity.startActivity(intent);
        activity.finish();
    }

    /* renamed from: b */
    public static boolean m10071b(Activity activity, Intent intent) {
        if (Build.VERSION.SDK_INT >= 16) {
            return activity.shouldUpRecreateTask(intent);
        }
        String action = activity.getIntent().getAction();
        return (action == null || action.equals("android.intent.action.MAIN")) ? false : true;
    }

    /* renamed from: b */
    public static String m10072b(Activity activity) {
        try {
            return m10070b(activity, activity.getComponentName());
        } catch (PackageManager.NameNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }

    /* renamed from: a */
    public static Intent m10075a(Activity activity) {
        Intent parentActivityIntent;
        if (Build.VERSION.SDK_INT < 16 || (parentActivityIntent = activity.getParentActivityIntent()) == null) {
            String m10072b = m10072b(activity);
            if (m10072b == null) {
                return null;
            }
            ComponentName componentName = new ComponentName(activity, m10072b);
            try {
                if (m10070b(activity, componentName) == null) {
                    return Intent.makeMainActivity(componentName);
                }
                return new Intent().setComponent(componentName);
            } catch (PackageManager.NameNotFoundException unused) {
                Log.e("NavUtils", "getParentActivityIntent: bad parentActivityName '" + m10072b + "' in manifest");
                return null;
            }
        }
        return parentActivityIntent;
    }

    /* renamed from: b */
    public static String m10070b(Context context, ComponentName componentName) {
        String string;
        String str;
        ActivityInfo activityInfo = context.getPackageManager().getActivityInfo(componentName, Logger.DEFAULT_FULL_MESSAGE_LENGTH);
        if (Build.VERSION.SDK_INT < 16 || (str = activityInfo.parentActivityName) == null) {
            if (activityInfo.metaData == null || (string = activityInfo.metaData.getString("android.support.PARENT_ACTIVITY")) == null) {
                return null;
            }
            if (string.charAt(0) == '.') {
                return context.getPackageName() + string;
            }
            return string;
        }
        return str;
    }

    /* renamed from: a */
    public static Intent m10073a(Context context, ComponentName componentName) {
        String m10070b = m10070b(context, componentName);
        if (m10070b == null) {
            return null;
        }
        ComponentName componentName2 = new ComponentName(componentName.getPackageName(), m10070b);
        if (m10070b(context, componentName2) == null) {
            return Intent.makeMainActivity(componentName2);
        }
        return new Intent().setComponent(componentName2);
    }
}
