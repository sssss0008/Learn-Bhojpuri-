package com.example.data

import android.content.Context
import android.speech.tts.TextToSpeech
import android.speech.tts.UtteranceProgressListener
import android.util.Log
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.util.Locale

class TtsHelper(context: Context) : TextToSpeech.OnInitListener {

    private var tts: TextToSpeech? = TextToSpeech(context.applicationContext, this)
    private var isInitialized = false

    private val _isSpeaking = MutableStateFlow(false)
    val isSpeaking: StateFlow<Boolean> = _isSpeaking.asStateFlow()

    private val _currentlySpeakingText = MutableStateFlow<String?>(null)
    val currentlySpeakingText: StateFlow<String?> = _currentlySpeakingText.asStateFlow()

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            val localeHi = Locale("hi", "IN")
            val localeNe = Locale("ne", "NP")

            val resultHi = tts?.setLanguage(localeHi)
            if (resultHi == TextToSpeech.LANG_MISSING_DATA || resultHi == TextToSpeech.LANG_NOT_SUPPORTED) {
                val resultNe = tts?.setLanguage(localeNe)
                if (resultNe == TextToSpeech.LANG_MISSING_DATA || resultNe == TextToSpeech.LANG_NOT_SUPPORTED) {
                    tts?.language = Locale.getDefault()
                }
            }
            tts?.setSpeechRate(0.85f) // Slightly relaxed pace optimal for language learning
            tts?.setPitch(1.0f)

            tts?.setOnUtteranceProgressListener(object : UtteranceProgressListener() {
                override fun onStart(utteranceId: String?) {
                    _isSpeaking.value = true
                }

                override fun onDone(utteranceId: String?) {
                    _isSpeaking.value = false
                    _currentlySpeakingText.value = null
                }

                @Deprecated("Deprecated in Java")
                override fun onError(utteranceId: String?) {
                    _isSpeaking.value = false
                    _currentlySpeakingText.value = null
                }
            })

            isInitialized = true
        } else {
            Log.e("TtsHelper", "TextToSpeech initialization failed with status: $status")
        }
    }

    fun speak(text: String, isSlow: Boolean = false) {
        if (!isInitialized || tts == null) return
        tts?.stop()

        val rate = if (isSlow) 0.65f else 0.85f
        tts?.setSpeechRate(rate)

        _currentlySpeakingText.value = text
        _isSpeaking.value = true

        val utteranceId = "bhojpuri_${System.currentTimeMillis()}"
        tts?.speak(text, TextToSpeech.QUEUE_FLUSH, null, utteranceId)
    }

    fun stop() {
        tts?.stop()
        _isSpeaking.value = false
        _currentlySpeakingText.value = null
    }

    fun shutdown() {
        tts?.stop()
        tts?.shutdown()
        tts = null
    }
}
