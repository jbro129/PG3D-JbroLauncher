package com.jbro129.mod.pg3dlauncher;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import java.util.Set;

import static android.content.Context.MODE_PRIVATE;

public class JPlayerPrefs
{
    private static JPlayerPrefs prefsInstance;
    private SharedPreferences sharedPreferences;

    private JPlayerPrefs(@NonNull Context paramContext)
    {
        this.sharedPreferences = paramContext.getSharedPreferences("com.pixel.gun3d.v2.playerprefs", MODE_PRIVATE);
    }

    private JPlayerPrefs(@NonNull Context paramContext, @NonNull String paramString)
    {
        this.sharedPreferences = paramContext.getSharedPreferences(paramString, MODE_PRIVATE);
    }

    public static JPlayerPrefs with(@NonNull Context paramContext)
    {
        if (prefsInstance == null) {
            prefsInstance = new JPlayerPrefs(paramContext);
        }
        return prefsInstance;
    }

    public static JPlayerPrefs with(@NonNull Context paramContext, @NonNull String paramString)
    {
        if (prefsInstance == null) {
            prefsInstance = new JPlayerPrefs(paramContext, paramString);
        }
        return prefsInstance;
    }

    public static JPlayerPrefs with(@NonNull Context paramContext, @NonNull String paramString, boolean paramBoolean)
    {
        if (paramBoolean) {
            prefsInstance = new JPlayerPrefs(paramContext, paramString);
        }
        return prefsInstance;
    }

    public static JPlayerPrefs with(@NonNull Context paramContext, boolean paramBoolean)
    {
        if (paramBoolean) {
            prefsInstance = new JPlayerPrefs(paramContext);
        }
        return prefsInstance;
    }

    public void clear()
    {
        this.sharedPreferences.edit().clear().apply();
    }

    public boolean contains(String paramString)
    {
        return this.sharedPreferences.contains(paramString);
    }

    public Set<String> getStringSet(String paramString, Set<String> paramSet)
    {
        return this.sharedPreferences.getStringSet(paramString, paramSet);
    }

    public void putStringSet(String paramString, Set<String> paramSet)
    {
        this.sharedPreferences.edit().putStringSet(paramString, paramSet).apply();
    }

    public String read(String paramString)
    {
        return this.sharedPreferences.getString(paramString, "");
    }

    public String read(String paramString1, String paramString2)
    {
        return this.sharedPreferences.getString(paramString1, paramString2);
    }

    public boolean readBoolean(String paramString)
    {
        return readBoolean(paramString, false);
    }

    public boolean readBoolean(String paramString, boolean paramBoolean)
    {
        return this.sharedPreferences.getBoolean(paramString, paramBoolean);
    }

    public double readDouble(String paramString)
    {
        if (!contains(paramString)) {
            return -1.0D;
        }
        return Double.longBitsToDouble(readLong(paramString));
    }

    public double readDouble(String paramString, double paramDouble)
    {
        if (!contains(paramString)) {
            return paramDouble;
        }
        return Double.longBitsToDouble(readLong(paramString));
    }

    public float readFloat(String paramString)
    {
        return this.sharedPreferences.getFloat(paramString, -1.0F);
    }

    public float readFloat(String paramString, float paramFloat)
    {
        return this.sharedPreferences.getFloat(paramString, paramFloat);
    }

    public int readInt(String paramString)
    {
        return this.sharedPreferences.getInt(paramString, -1);
    }

    public int readInt(String paramString, int paramInt)
    {
        return this.sharedPreferences.getInt(paramString, paramInt);
    }

    public long readLong(String paramString)
    {
        return this.sharedPreferences.getLong(paramString, -1L);
    }

    public long readLong(String paramString, long paramLong)
    {
        return this.sharedPreferences.getLong(paramString, paramLong);
    }

    public void remove(String paramString)
    {
        if (contains(paramString + "_length"))
        {
            int j = readInt(paramString + "_length");
            if (j >= 0)
            {
                this.sharedPreferences.edit().remove(paramString + "_length").apply();
                int i = 0;
                while (i < j)
                {
                    this.sharedPreferences.edit().remove(paramString + "[" + i + "]").apply();
                    i += 1;
                }
            }
        }
        this.sharedPreferences.edit().remove(paramString).apply();
    }

    public void write(String paramString1, String paramString2)
    {
        this.sharedPreferences.edit().putString(paramString1, paramString2).apply();
    }

    public void writeBoolean(String paramString, boolean paramBoolean)
    {
        this.sharedPreferences.edit().putBoolean(paramString, paramBoolean).apply();
    }

    public void writeDouble(String paramString, double paramDouble)
    {
        writeLong(paramString, Double.doubleToRawLongBits(paramDouble));
    }

    public void writeFloat(String paramString, float paramFloat)
    {
        this.sharedPreferences.edit().putFloat(paramString, paramFloat).apply();
    }

    public void writeInt(String paramString, int paramInt)
    {
        this.sharedPreferences.edit().putInt(paramString, paramInt).apply();
    }

    public void writeLong(String paramString, long paramLong)
    {
        this.sharedPreferences.edit().putLong(paramString, paramLong).apply();
    }
}
