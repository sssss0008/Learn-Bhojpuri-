package com.example.model

enum class WordCategory(val id: String, val bhojpuri: String, val nepali: String, val english: String, val icon: String) {
    ALL("all", "सभ", "सबै", "All", "✨"),
    GREETINGS("greetings", "प्रणाम-जोहार", "अभिवादन", "Greetings", "🙏"),
    PRONOUNS("pronouns", "सर्वनाम", "सर्वनाम", "Pronouns", "👥"),
    FAMILY("family", "परिवार", "परिवार", "Family", "👨‍👩‍👦"),
    NUMBERS("numbers", "गिनती", "गन्ती", "Numbers", "🔢"),
    DAILY_LIFE("daily", "रोजमर्रा", "दैनिक जीवन", "Daily Life", "☕"),
    FOOD("food", "खान-पान", "खाना-पान", "Food & Drink", "🍲"),
    VERBS("verbs", "क्रिया", "क्रियापद", "Common Verbs", "⚡"),
    TRAVEL("travel", "यात्रा अउर राह", "यात्रा र बाटो", "Travel & Way", "🚶"),
    MARKET("market", "बजार अउर मोलतोल", "बजार र किनमेल", "Market & Shop", "🛍️"),
    PROVERBS("proverbs", "कहावत", "उखान", "Proverbs", "📜");

    fun getLabel(lang: AppLanguage): String = when (lang) {
        AppLanguage.BHOJPURI -> bhojpuri
        AppLanguage.NEPALI -> nepali
        AppLanguage.ENGLISH -> english
    }
}

data class VocabularyItem(
    val id: String,
    val bhojpuri: String,
    val phonetic: String,
    val nepali: String,
    val english: String,
    val bhojpuriMeaning: String,
    val category: WordCategory,
    val exampleBhojpuri: String = "",
    val examplePhonetic: String = "",
    val exampleNepali: String = "",
    val exampleEnglish: String = "",
    val culturalNote: String = ""
) {
    fun getMeaning(lang: AppLanguage): String = when (lang) {
        AppLanguage.BHOJPURI -> bhojpuriMeaning
        AppLanguage.NEPALI -> nepali
        AppLanguage.ENGLISH -> english
    }

    fun getExampleTranslation(lang: AppLanguage): String = when (lang) {
        AppLanguage.BHOJPURI -> exampleBhojpuri
        AppLanguage.NEPALI -> exampleNepali
        AppLanguage.ENGLISH -> exampleEnglish
    }
}

data class Lesson(
    val id: String,
    val levelNumber: Int,
    val titleBhojpuri: String,
    val titleNepali: String,
    val titleEnglish: String,
    val descriptionBhojpuri: String,
    val descriptionNepali: String,
    val descriptionEnglish: String,
    val icon: String,
    val vocabularyIds: List<String>,
    val grammarTipBhojpuri: String,
    val grammarTipNepali: String,
    val grammarTipEnglish: String
) {
    fun getTitle(lang: AppLanguage): String = when (lang) {
        AppLanguage.BHOJPURI -> titleBhojpuri
        AppLanguage.NEPALI -> titleNepali
        AppLanguage.ENGLISH -> titleEnglish
    }

    fun getDescription(lang: AppLanguage): String = when (lang) {
        AppLanguage.BHOJPURI -> descriptionBhojpuri
        AppLanguage.NEPALI -> descriptionNepali
        AppLanguage.ENGLISH -> descriptionEnglish
    }

    fun getGrammarTip(lang: AppLanguage): String = when (lang) {
        AppLanguage.BHOJPURI -> grammarTipBhojpuri
        AppLanguage.NEPALI -> grammarTipNepali
        AppLanguage.ENGLISH -> grammarTipEnglish
    }
}

enum class QuizType {
    MULTIPLE_CHOICE,
    SENTENCE_BUILDER,
    LISTENING
}

data class QuizItem(
    val id: String,
    val type: QuizType,
    val promptBhojpuri: String,
    val promptNepali: String,
    val promptEnglish: String,
    val targetAudioText: String = "",
    val correctAnswer: String,
    val options: List<String> = emptyList(),
    val scrambledWords: List<String> = emptyList(),
    val explanationBhojpuri: String = "",
    val explanationNepali: String = "",
    val explanationEnglish: String = ""
) {
    fun getPrompt(lang: AppLanguage): String = when (lang) {
        AppLanguage.BHOJPURI -> promptBhojpuri
        AppLanguage.NEPALI -> promptNepali
        AppLanguage.ENGLISH -> promptEnglish
    }

    fun getExplanation(lang: AppLanguage): String = when (lang) {
        AppLanguage.BHOJPURI -> explanationBhojpuri
        AppLanguage.NEPALI -> explanationNepali
        AppLanguage.ENGLISH -> explanationEnglish
    }
}

data class DialogueLine(
    val speaker: String,
    val speakerTitleBhojpuri: String,
    val speakerTitleNepali: String,
    val speakerTitleEnglish: String,
    val bhojpuri: String,
    val phonetic: String,
    val nepali: String,
    val english: String,
    val isPrimarySpeaker: Boolean = true
) {
    fun getTranslation(lang: AppLanguage): String = when (lang) {
        AppLanguage.BHOJPURI -> bhojpuri
        AppLanguage.NEPALI -> nepali
        AppLanguage.ENGLISH -> english
    }

    fun getSpeakerName(lang: AppLanguage): String = when (lang) {
        AppLanguage.BHOJPURI -> speakerTitleBhojpuri
        AppLanguage.NEPALI -> speakerTitleNepali
        AppLanguage.ENGLISH -> speakerTitleEnglish
    }
}

data class ConversationDialogue(
    val id: String,
    val titleBhojpuri: String,
    val titleNepali: String,
    val titleEnglish: String,
    val scenarioBhojpuri: String,
    val scenarioNepali: String,
    val scenarioEnglish: String,
    val icon: String,
    val lines: List<DialogueLine>
) {
    fun getTitle(lang: AppLanguage): String = when (lang) {
        AppLanguage.BHOJPURI -> titleBhojpuri
        AppLanguage.NEPALI -> titleNepali
        AppLanguage.ENGLISH -> titleEnglish
    }

    fun getScenario(lang: AppLanguage): String = when (lang) {
        AppLanguage.BHOJPURI -> scenarioBhojpuri
        AppLanguage.NEPALI -> scenarioNepali
        AppLanguage.ENGLISH -> scenarioEnglish
    }
}

data class ProverbItem(
    val id: String,
    val bhojpuri: String,
    val phonetic: String,
    val literalMeaningBhojpuri: String,
    val nepaliEquivalent: String,
    val englishEquivalent: String,
    val explanationBhojpuri: String,
    val explanationNepali: String,
    val explanationEnglish: String
) {
    fun getExplanation(lang: AppLanguage): String = when (lang) {
        AppLanguage.BHOJPURI -> explanationBhojpuri
        AppLanguage.NEPALI -> explanationNepali
        AppLanguage.ENGLISH -> explanationEnglish
    }
}

data class GrammarExample(
    val bhojpuri: String,
    val phonetic: String,
    val nepali: String,
    val english: String,
    val note: String = ""
)

data class GrammarTopic(
    val id: String,
    val titleBhojpuri: String,
    val titleNepali: String,
    val titleEnglish: String,
    val ruleBhojpuri: String,
    val ruleNepali: String,
    val ruleEnglish: String,
    val icon: String,
    val examples: List<GrammarExample>
) {
    fun getTitle(lang: AppLanguage): String = when (lang) {
        AppLanguage.BHOJPURI -> titleBhojpuri
        AppLanguage.NEPALI -> titleNepali
        AppLanguage.ENGLISH -> titleEnglish
    }

    fun getRule(lang: AppLanguage): String = when (lang) {
        AppLanguage.BHOJPURI -> ruleBhojpuri
        AppLanguage.NEPALI -> ruleNepali
        AppLanguage.ENGLISH -> ruleEnglish
    }
}

data class CultureHistoryArticle(
    val id: String,
    val titleBhojpuri: String,
    val titleNepali: String,
    val titleEnglish: String,
    val subtitleBhojpuri: String,
    val subtitleNepali: String,
    val subtitleEnglish: String,
    val contentBhojpuri: String,
    val contentNepali: String,
    val contentEnglish: String,
    val iconEmoji: String,
    val drawableResName: String? = null,
    val categoryTag: String
) {
    fun getTitle(lang: AppLanguage): String = when (lang) {
        AppLanguage.BHOJPURI -> titleBhojpuri
        AppLanguage.NEPALI -> titleNepali
        AppLanguage.ENGLISH -> titleEnglish
    }

    fun getSubtitle(lang: AppLanguage): String = when (lang) {
        AppLanguage.BHOJPURI -> subtitleBhojpuri
        AppLanguage.NEPALI -> subtitleNepali
        AppLanguage.ENGLISH -> subtitleEnglish
    }

    fun getContent(lang: AppLanguage): String = when (lang) {
        AppLanguage.BHOJPURI -> contentBhojpuri
        AppLanguage.NEPALI -> contentNepali
        AppLanguage.ENGLISH -> contentEnglish
    }
}


