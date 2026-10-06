package com.example.model

enum class AppLanguage(val code: String, val displayName: String, val nativeName: String, val badge: String) {
    BHOJPURI("bho", "Bhojpuri", "भोजपुरी", "🌾"),
    NEPALI("ne", "Nepali", "नेपाली", "🇳🇵"),
    ENGLISH("en", "English", "English", "🌐");

    fun getUiString(bhojpuri: String, nepali: String, english: String): String {
        return when (this) {
            BHOJPURI -> bhojpuri
            NEPALI -> nepali
            ENGLISH -> english
        }
    }
}

object UiStrings {
    fun appTitle(lang: AppLanguage) = lang.getUiString("भोजपुरी सीखल जाव", "भोजपुरी सिकौं", "Learn Bhojpuri")
    fun homeTab(lang: AppLanguage) = lang.getUiString("गृह", "गृह", "Home")
    fun lessonsTab(lang: AppLanguage) = lang.getUiString("पाठ", "पाठहरू", "Lessons")
    fun practiceTab(lang: AppLanguage) = lang.getUiString("अभ्यास", "अभ्यास", "Practice")
    fun dictionaryTab(lang: AppLanguage) = lang.getUiString("शब्दकोश", "शब्दकोश", "Dictionary")
    fun cultureTab(lang: AppLanguage) = lang.getUiString("संस्कृति", "संस्कृति", "Culture")
    fun searchHint(lang: AppLanguage) = lang.getUiString("भोजपुरी, नेपाली या अंग्रेजी में खोजीं...", "भोजपुरी, नेपाली वा अंग्रेजीमा खोज्नुहोस्...", "Search Bhojpuri, Nepali, or English...")
    fun dailyStreak(lang: AppLanguage) = lang.getUiString("दिन के लगन", "दैनिक निरन्तरता", "Daily Streak")
    fun days(lang: AppLanguage) = lang.getUiString("दिन", "दिन", "days")
    fun xpPoints(lang: AppLanguage) = lang.getUiString("अंक", "अङ्क", "XP")
    fun wordOfTheDay(lang: AppLanguage) = lang.getUiString("आज के शब्द", "आजको शब्द", "Word of the Day")
    fun flashcards(lang: AppLanguage) = lang.getUiString("फ्लैशकार्ड", "फ्ल्यासकार्ड", "Flashcards")
    fun takeQuiz(lang: AppLanguage) = lang.getUiString("परीक्षा लीं", "क्विज खेल्नुहोस्", "Take Quiz")
    fun sentenceBuilder(lang: AppLanguage) = lang.getUiString("वाक्य बनावीं", "वाक्य बनाउनुहोस्", "Sentence Builder")
    fun conversations(lang: AppLanguage) = lang.getUiString("बातचीत", "कुराकानी", "Conversations")
    fun grammarGuide(lang: AppLanguage) = lang.getUiString("व्याकरण", "व्याकरण", "Grammar")
    fun proverbs(lang: AppLanguage) = lang.getUiString("कहावत अउर मुहावरा", "उखान र टुक्का", "Proverbs & Sayings")
    fun tapToFlip(lang: AppLanguage) = lang.getUiString("अर्थ देखे खातिर छुईं", "अर्थ हेर्न छुनुहोस्", "Tap to flip card")
    fun mastered(lang: AppLanguage) = lang.getUiString("याद भइल", "कण्ठ भयो", "Mastered")
    fun reviewLater(lang: AppLanguage) = lang.getUiString("फेरु देखीं", "फेरि दोहोर्याउने", "Review Later")
    fun listenAudio(lang: AppLanguage) = lang.getUiString("उच्चारण सुनीं", "उच्चारण सुन्नुहोस्", "Listen Pronunciation")
    fun slowAudio(lang: AppLanguage) = lang.getUiString("धीरे सुनीं", "बिस्तारै सुन्नुहोस्", "Slow Audio")
    fun congratulations(lang: AppLanguage) = lang.getUiString("बधाई बा!", "बधाई छ!", "Congratulations!")
    fun correct(lang: AppLanguage) = lang.getUiString("सही जवाब!", "सही उत्तर!", "Correct Answer!")
    fun wrong(lang: AppLanguage) = lang.getUiString("गलत जवाब", "गलत उत्तर", "Wrong Answer")
    fun check(lang: AppLanguage) = lang.getUiString("जाँचीं", "जाँच्नुहोस्", "Check")
    fun next(lang: AppLanguage) = lang.getUiString("अगिला", "अर्को", "Next")
    fun finish(lang: AppLanguage) = lang.getUiString("पूरा भइल", "सम्पन्न भयो", "Finish")
    fun bookmarks(lang: AppLanguage) = lang.getUiString("पसंदीदा", "मनपर्ने", "Favorites")
    fun selectLanguage(lang: AppLanguage) = lang.getUiString("भाषा चुनीं", "भाषा रोज्नुहोस्", "Choose Language")
    fun learnTab(lang: AppLanguage) = lang.getUiString("सीखीं", "सिक्नुहोस्", "Learn")
    fun aboutTab(lang: AppLanguage) = lang.getUiString("बारे में", "विवरण", "About App")
    fun cultureHistory(lang: AppLanguage) = lang.getUiString("संस्कृति अउर इतिहास", "संस्कृति र इतिहास", "Culture & History")
    fun feedback(lang: AppLanguage) = lang.getUiString("प्रतिक्रिया", "प्रतिक्रिया", "Feedback")
    fun contactDeveloper(lang: AppLanguage) = lang.getUiString("सम्पर्क अउर डेवलपर", "सम्पर्क र विकासकर्ता", "Developer & Contact")
    fun quickPractice(lang: AppLanguage) = lang.getUiString("शीघ्र अभ्यास", "द्रुत अभ्यास", "Quick Practice")
}
