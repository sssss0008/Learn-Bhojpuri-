package com.example.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = SaffronPrimaryDark,
    onPrimary = Color(0xFF431300),
    primaryContainer = SaffronContainerDark,
    onPrimaryContainer = Color(0xFFFFDBCF),
    secondary = PeacockTealDark,
    onSecondary = Color(0xFF00373C),
    secondaryContainer = Color(0xFF004F56),
    onSecondaryContainer = Color(0xFF9CF0F8),
    tertiary = GoldenAmberLight,
    onTertiary = Color(0xFF442B00),
    background = BackgroundDark,
    onBackground = TextPrimaryLight,
    surface = SurfaceDark,
    onSurface = TextPrimaryLight,
    surfaceVariant = SurfaceVariantDark,
    onSurfaceVariant = TextSecondaryLight
)

private val LightColorScheme = lightColorScheme(
    primary = SaffronPrimary,
    onPrimary = Color.White,
    primaryContainer = SaffronContainer,
    onPrimaryContainer = OnSaffronContainer,
    secondary = PeacockTeal,
    onSecondary = Color.White,
    secondaryContainer = PeacockTealContainer,
    onSecondaryContainer = OnPeacockTealContainer,
    tertiary = GoldenAmber,
    onTertiary = Color.White,
    background = WarmBackgroundLight,
    onBackground = TextPrimaryDark,
    surface = WarmSurfaceLight,
    onSurface = TextPrimaryDark,
    surfaceVariant = WarmSurfaceVariant,
    onSurfaceVariant = TextSecondaryDark
)

@Composable
fun BhojpuriBhasaTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Keep bespoke branding consistent by default
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit,
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
