package com.example.data

import com.example.model.*

object BhojpuriDataSource {

    val vocabularies = listOf(
        // Greetings
        VocabularyItem(
            id = "g1",
            bhojpuri = "प्रणाम",
            phonetic = "Pranaam",
            nepali = "नमस्कार / प्रणाम",
            english = "Greetings / Respectful Hello",
            bhojpuriMeaning = "बड़का लोग के आदर से जोहार करे के तरीका",
            category = WordCategory.GREETINGS,
            exampleBhojpuri = "काका, रउआ के प्रणाम!",
            examplePhonetic = "Kaka, rauaa ke pranaam!",
            exampleNepali = "काका, हजुरलाई नमस्कार!",
            exampleEnglish = "Uncle, respectful greetings to you!",
            culturalNote = "Bhojpuri culture places highest regard on greeting elders with Pranaam or touching feet."
        ),
        VocabularyItem(
            id = "g2",
            bhojpuri = "गोड़ लागतानी",
            phonetic = "Gor laagataani",
            nepali = "गोडा ढोग्दछु / ढोगेँ",
            english = "I bow to your feet (Traditional respect)",
            bhojpuriMeaning = "पाँव छू के आशीर्वाद लेबे के निहोरा",
            category = WordCategory.GREETINGS,
            exampleBhojpuri = "माई, हम रउआ गोड़ लागतानी।",
            examplePhonetic = "Maai, hum rauaa gor laagataani.",
            exampleNepali = "आमा, म हजुरको गोडा ढोग्दछु।",
            exampleEnglish = "Mother, I touch your feet with reverence.",
            culturalNote = "Most polite phrase spoken when meeting parents, grandparents, or respected elders."
        ),
        VocabularyItem(
            id = "g3",
            bhojpuri = "रउआ कइसे बानी?",
            phonetic = "Rauaa kaise baani?",
            nepali = "हजुरलाई कस्तो छ? / तपाईं कस्तो हुनुहुन्छ?",
            english = "How are you? (Formal & Respectful)",
            bhojpuriMeaning = "आदर के साथे कुशल-मंगल पूछल",
            category = WordCategory.GREETINGS,
            exampleBhojpuri = "भईया, रउआ कइसे बानी?",
            examplePhonetic = "Bhaiya, rauaa kaise baani?",
            exampleNepali = "दाइ, हजुरलाई कस्तो छ?",
            exampleEnglish = "Brother, how are you doing?",
            culturalNote = "'रउआ' is the polite 'you', conjugated with 'बानी'."
        ),
        VocabularyItem(
            id = "g4",
            bhojpuri = "का हाल बा?",
            phonetic = "Kaa haal ba?",
            nepali = "के छ खबर? / के हालचाल?",
            english = "What's up? / How are you doing? (Informal)",
            bhojpuriMeaning = "दोस्त-यार से हालचाल पूछे के सहज तरीका",
            category = WordCategory.GREETINGS,
            exampleBhojpuri = "अरे यार, तोहार का हाल बा?",
            examplePhonetic = "Are yaar, tohaar kaa haal ba?",
            exampleNepali = "ए साथी, तिम्रो के छ खबर?",
            exampleEnglish = "Hey friend, how are you doing?",
            culturalNote = "Commonly used among equals, close friends, and younger peers."
        ),
        VocabularyItem(
            id = "g5",
            bhojpuri = "हम ठीक बानी",
            phonetic = "Hum theek baani",
            nepali = "म ठीक छु / मलाई सन्चै छ",
            english = "I am fine / I am doing well",
            bhojpuriMeaning = "अपन तबीयत या हाल ठीक बतावे के वाक्य",
            category = WordCategory.GREETINGS,
            exampleBhojpuri = "हम ठीक बानी, अपन बताईं।",
            examplePhonetic = "Hum theek baani, apan bataai.",
            exampleNepali = "म ठीक छु, आफ्नो भन्नुहोस्।",
            exampleEnglish = "I am fine, please tell about yourself."
        ),
        VocabularyItem(
            id = "g6",
            bhojpuri = "धन्यवाद / मेहरबानी",
            phonetic = "Dhanyawaad / Meharbaani",
            nepali = "धन्यवाद",
            english = "Thank you",
            bhojpuriMeaning = "कृतज्ञता अउर आभार प्रकट करल",
            category = WordCategory.GREETINGS,
            exampleBhojpuri = "राउर बहुत बहुत धन्यवाद!",
            examplePhonetic = "Raur bahut bahut dhanyawaad!",
            exampleNepali = "हजुरलाई धेरै धेरै धन्यवाद!",
            exampleEnglish = "Thank you very much!"
        ),
        VocabularyItem(
            id = "g7",
            bhojpuri = "फेरु भेंट होई",
            phonetic = "Pheru bhent hoi",
            nepali = "फेरि भेटौँला",
            english = "See you again / Farewell",
            bhojpuriMeaning = "विदा लेत घरी फेर मिले के बात कहल",
            category = WordCategory.GREETINGS,
            exampleBhojpuri = "अच्छा चलल जाव, फेरु भेंट होई।",
            examplePhonetic = "Achha chalal jaav, pheru bhent hoi.",
            exampleNepali = "ल अब जाऔँ, फेरि भेटौँला।",
            exampleEnglish = "Alright let's go, we will meet again."
        ),
        VocabularyItem(
            id = "g8",
            bhojpuri = "हँ / ना",
            phonetic = "Haan / Naa",
            nepali = "हो / होइन (अँ / नाइँ)",
            english = "Yes / No",
            bhojpuriMeaning = "सहमति भा असहमति बतावे के शब्द",
            category = WordCategory.GREETINGS,
            exampleBhojpuri = "हँ, हम जरूर आएम।",
            examplePhonetic = "Haan, hum jaroor aaem.",
            exampleNepali = "हो, म अवश्य आउनेछु।",
            exampleEnglish = "Yes, I will definitely come."
        ),

        // Pronouns
        VocabularyItem(
            id = "p1",
            bhojpuri = "हम",
            phonetic = "Hum",
            nepali = "म",
            english = "I / Me",
            bhojpuriMeaning = "अपन खातिर कहल जाए वाला पहिलका सर्वनाम",
            category = WordCategory.PRONOUNS,
            exampleBhojpuri = "हम भोजपुरी सीखतानी।",
            examplePhonetic = "Hum Bhojpuri seekhtaani.",
            exampleNepali = "म भोजपुरी सिक्दैछु।",
            exampleEnglish = "I am learning Bhojpuri.",
            culturalNote = "In Bhojpuri, 'हम' (Hum) means 'I', unlike standard Hindi where it often means 'we'."
        ),
        VocabularyItem(
            id = "p2",
            bhojpuri = "हमनी / हमनी के",
            phonetic = "Hamani / Hamani ke",
            nepali = "हामी / हामीहरू",
            english = "We / Us",
            bhojpuriMeaning = "एक से ढेर लोग जब अपन बात कहेला",
            category = WordCategory.PRONOUNS,
            exampleBhojpuri = "हमनी के बजार जात बानी।",
            examplePhonetic = "Hamani ke bajaar jaat baani.",
            exampleNepali = "हामीहरू बजार जाँदैछौँ।",
            exampleEnglish = "We are going to the market."
        ),
        VocabularyItem(
            id = "p3",
            bhojpuri = "रउआ",
            phonetic = "Rauaa",
            nepali = "तपाईँ / हजुर",
            english = "You (Formal / Respectful)",
            bhojpuriMeaning = "आदरणीय व्यक्ति खातिर कहल जाए वाला शब्द",
            category = WordCategory.PRONOUNS,
            exampleBhojpuri = "रउआ कहाँ जात बानी?",
            examplePhonetic = "Rauaa kahaan jaat baani?",
            exampleNepali = "तपाईँ कहाँ जाँदै हुनुहुन्छ?",
            exampleEnglish = "Where are you going?"
        ),
        VocabularyItem(
            id = "p4",
            bhojpuri = "तू / तूँ",
            phonetic = "Tu / Toon",
            nepali = "तिमी / तँ",
            english = "You (Informal / Friendly)",
            bhojpuriMeaning = "बराबर या छोट लोग खातिर सम्बोधन",
            category = WordCategory.PRONOUNS,
            exampleBhojpuri = "तू कब अईबे?",
            examplePhonetic = "Tu kab aibe?",
            exampleNepali = "तिमी कहिले आउँछौ?",
            exampleEnglish = "When will you come?"
        ),
        VocabularyItem(
            id = "p5",
            bhojpuri = "अपने",
            phonetic = "Apne",
            nepali = "हजुर (अत्यन्त आदरणीय)",
            english = "You (Ultra Honorific)",
            bhojpuriMeaning = "अति आदरणीय साधु, गुरु भा सम्मानित जन खातिर",
            category = WordCategory.PRONOUNS,
            exampleBhojpuri = "अपने बईठल जाव।",
            examplePhonetic = "Apne baithal jaav.",
            exampleNepali = "हजुर बस्नुहोस्।",
            exampleEnglish = "Please be seated (highly respectful)."
        ),
        VocabularyItem(
            id = "p6",
            bhojpuri = "हमार / तोहार / राउर",
            phonetic = "Hamaar / Tohaar / Raaur",
            nepali = "मेरो / तिम्रो / हजुरको",
            english = "My / Your (inf) / Your (polite)",
            bhojpuriMeaning = "अपनत्व बतावे वाला सम्बंधी शब्द",
            category = WordCategory.PRONOUNS,
            exampleBhojpuri = "ई हमार घर हवे, राउर कवन ह?",
            examplePhonetic = "Ee hamaar ghar have, raaur kawan ha?",
            exampleNepali = "यो मेरो घर हो, हजुरको कुन हो?",
            exampleEnglish = "This is my house, which one is yours?"
        ),

        // Family
        VocabularyItem(
            id = "f1",
            bhojpuri = "माई / महतारी",
            phonetic = "Maai / Mahtaari",
            nepali = "आमा / माता",
            english = "Mother",
            bhojpuriMeaning = "जनम देवे वाली ममतामयी महतारी",
            category = WordCategory.FAMILY,
            exampleBhojpuri = "माई बहुत मीठ भात-दाल बनावेली।",
            examplePhonetic = "Maai bahut meeth bhaat-daal banaaweli.",
            exampleNepali = "आमाले एकदमै मिठो दाल-भात बनाउनुहुन्छ।",
            exampleEnglish = "Mother cooks very delicious rice and lentils."
        ),
        VocabularyItem(
            id = "f2",
            bhojpuri = "बाबूजी / बाउजी",
            phonetic = "Baabooji / Baauji",
            nepali = "बुबा / पिताजी",
            english = "Father",
            bhojpuriMeaning = "घर के मुखिया पिता",
            category = WordCategory.FAMILY,
            exampleBhojpuri = "बाबूजी खेत से घरे अईलन।",
            examplePhonetic = "Baabooji khet se ghare ailan.",
            exampleNepali = "बुबा खेतबाट घर आउनुभयो।",
            exampleEnglish = "Father came home from the farm."
        ),
        VocabularyItem(
            id = "f3",
            bhojpuri = "भईया / भाई",
            phonetic = "Bhaiya / Bhaai",
            nepali = "दाइ / भाइ",
            english = "Elder brother / Brother",
            bhojpuriMeaning = "बड़का भा छोट सहोदर भाई",
            category = WordCategory.FAMILY,
            exampleBhojpuri = "हमार भईया शहर में नौकरी करेलन।",
            examplePhonetic = "Hamaar bhaiya shahar me naukari karelan.",
            exampleNepali = "मेरो दाइ शहरमा जागिर गर्नुहुन्छ।",
            exampleEnglish = "My elder brother works in the city."
        ),
        VocabularyItem(
            id = "f4",
            bhojpuri = "भौजी / भौजाई",
            phonetic = "Bhauji / Bhaujaai",
            nepali = "भाउजू",
            english = "Sister-in-law (Elder brother's wife)",
            bhojpuriMeaning = "बड़का भईया के पत्नी",
            category = WordCategory.FAMILY,
            exampleBhojpuri = "भौजी के हाथ के लिट्टी खूब नीमन होला।",
            examplePhonetic = "Bhauji ke haath ke litti khoob neeman hola.",
            exampleNepali = "भाउजूको हातको लिट्टी असाध्यै राम्रो हुन्छ।",
            exampleEnglish = "Sister-in-law makes very tasty Litti."
        ),
        VocabularyItem(
            id = "f5",
            bhojpuri = "बहिन / दीदी",
            phonetic = "Bahin / Deedi",
            nepali = "दिदी / बहिनी",
            english = "Sister",
            bhojpuriMeaning = "सहोदर बहिन भा दीदी",
            category = WordCategory.FAMILY,
            exampleBhojpuri = "हमार बहिन इस्कूल पढ़तिया।",
            examplePhonetic = "Hamaar bahin iskool padhatiya.",
            exampleNepali = "मेरी बहिनी विद्यालय पढ्दैछिन्।",
            exampleEnglish = "My sister is studying at school."
        ),
        VocabularyItem(
            id = "f6",
            bhojpuri = "काका / काकी",
            phonetic = "Kaaka / Kaaki",
            nepali = "काका / काकी",
            english = "Uncle / Aunt (Paternal)",
            bhojpuriMeaning = "बाबूजी के छोट भाई अउर उनकर घरवाली",
            category = WordCategory.FAMILY,
            exampleBhojpuri = "काका आज जनकपुर से अईलन।",
            examplePhonetic = "Kaaka aaj Janakpur se ailan.",
            exampleNepali = "काका आज जनकपुरबाट आउनुभयो।",
            exampleEnglish = "Uncle arrived from Janakpur today."
        ),
        VocabularyItem(
            id = "f7",
            bhojpuri = "बबुआ / बबुनी",
            phonetic = "Babua / Babuni",
            nepali = "बाबु / नानी (सानो बालक/बालिका)",
            english = "Little boy / Little girl",
            bhojpuriMeaning = "छोट लइका या लइकी के दुलार के नाम",
            category = WordCategory.FAMILY,
            exampleBhojpuri = "बबुआ, इहाँ आवा खेलल जाव।",
            examplePhonetic = "Babua, ihaan aawa khelal jaav.",
            exampleNepali = "बाबु, यहाँ आऊ खेलौँ।",
            exampleEnglish = "Little boy, come here and let's play."
        ),

        // Numbers
        VocabularyItem(
            id = "n1",
            bhojpuri = "एक (१)",
            phonetic = "Ek",
            nepali = "एक (१)",
            english = "One (1)",
            bhojpuriMeaning = "पहिलका संख्या",
            category = WordCategory.NUMBERS,
            exampleBhojpuri = "हमरा एक गिलास पानी चाहीं।",
            examplePhonetic = "Hamra ek gilaas paani chaahin.",
            exampleNepali = "मलाई एक गिलास पानी चाहिन्छ।",
            exampleEnglish = "I need one glass of water."
        ),
        VocabularyItem(
            id = "n2",
            bhojpuri = "दु (२)",
            phonetic = "Du",
            nepali = "दुई (२)",
            english = "Two (2)",
            bhojpuriMeaning = "दोसरका संख्या",
            category = WordCategory.NUMBERS,
            exampleBhojpuri = "दु गो चाय ले आईब।",
            examplePhonetic = "Du go chaay le aaib.",
            exampleNepali = "दुई वटा चिया लिएर आउनुस्।",
            exampleEnglish = "Please bring two cups of tea."
        ),
        VocabularyItem(
            id = "n3",
            bhojpuri = "तीन (३)",
            phonetic = "Teen",
            nepali = "तीन (३)",
            english = "Three (3)",
            bhojpuriMeaning = "तेसरका संख्या",
            category = WordCategory.NUMBERS,
            exampleBhojpuri = "तीन दिन बाद हम घरे जाएम।",
            examplePhonetic = "Teen din baad hum ghare jaaem.",
            exampleNepali = "तीन दिनपछि म घर जानेछु।",
            exampleEnglish = "I will go home after three days."
        ),
        VocabularyItem(
            id = "n4",
            bhojpuri = "चार (४) अउर पाँच (५)",
            phonetic = "Chaar aur Paanch",
            nepali = "चार (४) र पाँच (५)",
            english = "Four (4) and Five (5)",
            bhojpuriMeaning = "चार आ पाँच संख्या",
            category = WordCategory.NUMBERS,
            exampleBhojpuri = "हमरा पाँच गो आम चाहीं।",
            examplePhonetic = "Hamra paanch go aam chaahin.",
            exampleNepali = "मलाई पाँच वटा आँप चाहिन्छ।",
            exampleEnglish = "I need five mangoes."
        ),
        VocabularyItem(
            id = "n5",
            bhojpuri = "दस (१०) / बीस (२०)",
            phonetic = "Das / Bees",
            nepali = "दश (१०) / बीस (२०)",
            english = "Ten (10) / Twenty (20)",
            bhojpuriMeaning = "दस आ बीस के गिनती",
            category = WordCategory.NUMBERS,
            exampleBhojpuri = "एकर दाम बीस रूपिया बा।",
            examplePhonetic = "Ekar daam bees rupiya ba.",
            exampleNepali = "यसको मूल्य बीस रुपैयाँ हो।",
            exampleEnglish = "The price of this is twenty rupees."
        ),
        VocabularyItem(
            id = "n6",
            bhojpuri = "पचास (५०) / सौ (१००)",
            phonetic = "Pachaas / Sau",
            nepali = "पचास (५०) / सय (१००)",
            english = "Fifty (50) / Hundred (100)",
            bhojpuriMeaning = "पचास आ एक सौ",
            category = WordCategory.NUMBERS,
            exampleBhojpuri = "एक सौ रूपिया में दीं।",
            examplePhonetic = "Ek sau rupiya me deen.",
            exampleNepali = "एक सय रुपैयाँमा दिनुहोस्।",
            exampleEnglish = "Give it for one hundred rupees."
        ),

        // Food & Cuisine
        VocabularyItem(
            id = "fd1",
            bhojpuri = "लिट्टी चोखा",
            phonetic = "Litti Chokha",
            nepali = "लिट्टी चोखा (परम्परागत परिकार)",
            english = "Litti Chokha (Signature Bhojpuri delicacy)",
            bhojpuriMeaning = "सत्तू भरल लिट्टी अउर भूंजाल बैंगन-टमाटर के चोखा",
            category = WordCategory.FOOD,
            exampleBhojpuri = "गरमा-गरम लिट्टी चोखा खाए में बड़ा आनंद आवेला।",
            examplePhonetic = "Garma-garam litti chokha khaaye me bada aanand aawela.",
            exampleNepali = "तातो-तातो लिट्टी चोखा खान असाध्यै मज्जा आउँछ।",
            exampleEnglish = "Eating piping hot Litti Chokha brings immense joy."
        ),
        VocabularyItem(
            id = "fd2",
            bhojpuri = "भात, दाल अउर भुजिया",
            phonetic = "Bhaat, Daal aur Bhujiya",
            nepali = "भात, दाल र भुटेको तरकारी (भुजिया)",
            english = "Rice, Lentils and Fried vegetables",
            bhojpuriMeaning = "रोज के मुख्य देसी भोजन",
            category = WordCategory.FOOD,
            exampleBhojpuri = "दुपहरी में भात-दाल अउर आलू के भुजिया बनेला।",
            examplePhonetic = "Dupahari me bhaat-daal aur aalu ke bhujiya banela.",
            exampleNepali = "दिउँसोमा दाल-भात र आलुको भुजिया पाक्छ।",
            exampleEnglish = "In the afternoon, rice, dal, and crispy potato fry are made."
        ),
        VocabularyItem(
            id = "fd3",
            bhojpuri = "पानी / जल",
            phonetic = "Paani / Jal",
            nepali = "पानी",
            english = "Water",
            bhojpuriMeaning = "पियास बुझावे वाला तरल",
            category = WordCategory.FOOD,
            exampleBhojpuri = "शीतल पानी पियाईं, बड़ी पियास लागल बा।",
            examplePhonetic = "Sheetal paani piyaai, badi piyaas laagal ba.",
            exampleNepali = "चिसो पानी खुवाउनुहोस्, साह्रै तिर्खा लागेको छ।",
            exampleEnglish = "Please give cold water, I am very thirsty."
        ),
        VocabularyItem(
            id = "fd4",
            bhojpuri = "चाय / चाहा",
            phonetic = "Chaay / Chaaha",
            nepali = "चिया",
            english = "Tea",
            bhojpuriMeaning = "मसालेदार देसी चाय",
            category = WordCategory.FOOD,
            exampleBhojpuri = "अदरक डाल के कड़क चाय बनावीं।",
            examplePhonetic = "Adarak daal ke kadak chaay banaavi.",
            exampleNepali = "अदुवा हालेर कडा चिया बनाउनुहोस्।",
            exampleEnglish = "Make strong tea with ginger."
        ),
        VocabularyItem(
            id = "fd5",
            bhojpuri = "ठेकुआ",
            phonetic = "Thekua",
            nepali = "ठेकुवा (छठ पर्वको विशेष प्रसाद)",
            english = "Thekua (Traditional sweet crust prasad)",
            bhojpuriMeaning = "छठ पूजा के मुख्य अउर पवित्र प्रसाद",
            category = WordCategory.FOOD,
            exampleBhojpuri = "छठ के ठेकुआ के स्वाद अलगे होला।",
            examplePhonetic = "Chhath ke thekua ke swaad alage hola.",
            exampleNepali = "छठको ठेकुवाको स्वाद बेग्लै हुन्छ।",
            exampleEnglish = "The divine taste of Chhath's Thekua is unique."
        ),

        // Verbs
        VocabularyItem(
            id = "v1",
            bhojpuri = "खाएब (खातानी / खाईब)",
            phonetic = "Khaaeb (Khaataani / Khaaib)",
            nepali = "खानु (खाइरहेको छु / खानेछु)",
            english = "To Eat (I am eating / I will eat)",
            bhojpuriMeaning = "भोजन ग्रहण करल",
            category = WordCategory.VERBS,
            exampleBhojpuri = "हम भात खातानी, रउआ खईनी?",
            examplePhonetic = "Hum bhaat khaataani, rauaa khaini?",
            exampleNepali = "म भात खाँदैछु, हजुरले खानुभयो?",
            exampleEnglish = "I am eating rice, did you eat?"
        ),
        VocabularyItem(
            id = "v2",
            bhojpuri = "जाएब (जातानी / जाईब)",
            phonetic = "Jaaeb (Jaataani / Jaaib)",
            nepali = "जानु (जाँदैछु / जानेछु)",
            english = "To Go (I am going / I will go)",
            bhojpuriMeaning = "कवनो जगह पर प्रस्थान करल",
            category = WordCategory.VERBS,
            exampleBhojpuri = "हम साँझ के वीरगंज जाईब।",
            examplePhonetic = "Hum saanjh ke Birgunj jaaib.",
            exampleNepali = "म साँझमा वीरगञ्ज जानेछु।",
            exampleEnglish = "I will go to Birgunj in the evening."
        ),
        VocabularyItem(
            id = "v3",
            bhojpuri = "आवेब (आवतानी / आएम)",
            phonetic = "Aaweb (Aawataani / Aaaem)",
            nepali = "आउनु (आउँदैछु / आउनेछु)",
            english = "To Come (I am coming / I will come)",
            bhojpuriMeaning = "कहिंयो से घरे भा जगह पर लवटल",
            category = WordCategory.VERBS,
            exampleBhojpuri = "रउआ कब आवतानी?",
            examplePhonetic = "Rauaa kab aawataani?",
            exampleNepali = "हजुर कहिले आउँदै हुनुहुन्छ?",
            exampleEnglish = "When are you coming?"
        ),
        VocabularyItem(
            id = "v4",
            bhojpuri = "बोलेब (बोलतानी)",
            phonetic = "Boleb (Boltaani)",
            nepali = "बोल्नु (बोल्दैछु)",
            english = "To Speak (I speak)",
            bhojpuriMeaning = "मुख से शब्द कहल",
            category = WordCategory.VERBS,
            exampleBhojpuri = "हम मीठ भोजपुरी बोलीला।",
            examplePhonetic = "Hum meeth Bhojpuri boleela.",
            exampleNepali = "म मिठो भोजपुरी बोल्छु।",
            exampleEnglish = "I speak sweet Bhojpuri."
        ),
        VocabularyItem(
            id = "v5",
            bhojpuri = "बुझेब (बुझतानी)",
            phonetic = "Bujheb (Bujhtaani)",
            nepali = "बुझ्नु (बुझ्दैछु / बुझेँ)",
            english = "To Understand (I understand)",
            bhojpuriMeaning = "कवनो बात समझ में आवे के क्रिया",
            category = WordCategory.VERBS,
            exampleBhojpuri = "का रउआ हमार बात बुझतानी?",
            examplePhonetic = "Kaa rauaa hamaar baat bujhtaani?",
            exampleNepali = "के हजुरले मेरो कुरा बुझ्दै हुनुहुन्छ?",
            exampleEnglish = "Do you understand what I am saying?"
        ),
        VocabularyItem(
            id = "v6",
            bhojpuri = "सूतेब (सूततानी)",
            phonetic = "Sooteb (Soottaani)",
            nepali = "सुत्नु (सुत्दैछु)",
            english = "To Sleep",
            bhojpuriMeaning = "नींद लेबे के क्रिया",
            category = WordCategory.VERBS,
            exampleBhojpuri = "रात हो गइल, अब सूतल जाव।",
            examplePhonetic = "Raat ho gail, ab sootal jaav.",
            exampleNepali = "रात पर्यो, अब सुतौँ।",
            exampleEnglish = "It is night now, let us sleep."
        ),

        // Market & Bargaining
        VocabularyItem(
            id = "m1",
            bhojpuri = "एकर का दाम बा?",
            phonetic = "Ekar kaa daam ba?",
            nepali = "यसको कति मूल्य हो? / कति पर्छ?",
            english = "How much does this cost?",
            bhojpuriMeaning = "चीज के भाव या कीमत पूछल",
            category = WordCategory.MARKET,
            exampleBhojpuri = "दुकानदार भईया, ई आम के का दाम बा?",
            examplePhonetic = "Dukaandaar bhaiya, ee aam ke kaa daam ba?",
            exampleNepali = "साहुजी, यो आँपको मूल्य कति हो?",
            exampleEnglish = "Shopkeeper brother, how much is this mango?"
        ),
        VocabularyItem(
            id = "m2",
            bhojpuri = "तनिक कम करीं ना!",
            phonetic = "Tanik kam kareen naa!",
            nepali = "अलिकति घटाउनुस् न!",
            english = "Please reduce the price a little!",
            bhojpuriMeaning = "मोलभाव में दाम घटवावे के विनय",
            category = WordCategory.MARKET,
            exampleBhojpuri = "बहुत महंग कहत बानी, तनिक कम करीं ना!",
            examplePhonetic = "Bahut mahang kahat baani, tanik kam kareen naa!",
            exampleNepali = "धेरै महङ्गो भन्नुभयो, अलिकति घटाउनुस् न!",
            exampleEnglish = "You quoted too high, please reduce it a bit!"
        ),
        VocabularyItem(
            id = "m3",
            bhojpuri = "सस्ता / महंग",
            phonetic = "Sasta / Mahang",
            nepali = "सस्तो / महङ्गो",
            english = "Cheap (Affordable) / Expensive",
            bhojpuriMeaning = "कम दाम भा बेसी दाम",
            category = WordCategory.MARKET,
            exampleBhojpuri = "ई दोकान पर सामान सस्ता मिलेला।",
            examplePhonetic = "Ee dokaan par saamaan sasta milela.",
            exampleNepali = "यो पसलमा सामान सस्तो पाइन्छ।",
            exampleEnglish = "Items are cheap at this shop."
        ),
        VocabularyItem(
            id = "m4",
            bhojpuri = "ताजा बा कि ना?",
            phonetic = "Taaja ba ki naa?",
            nepali = "ताजा छ कि छैन?",
            english = "Is it fresh or not?",
            bhojpuriMeaning = "तरकारी भा फल के ताजगी जांचल",
            category = WordCategory.MARKET,
            exampleBhojpuri = "सब्जी एकदम खेत के ताजा बा।",
            examplePhonetic = "Sabji ekdam khet ke taaja ba.",
            exampleNepali = "तरकारी एकदम खेतको ताजा छ।",
            exampleEnglish = "The vegetable is fresh directly from the farm."
        ),

        // Travel & Way
        VocabularyItem(
            id = "tr1",
            bhojpuri = "कतेक दूर बा?",
            phonetic = "Katek door ba?",
            nepali = "कति टाढा छ?",
            english = "How far is it?",
            bhojpuriMeaning = "दूरी के जानकारी लेबे खातिर सवाल",
            category = WordCategory.TRAVEL,
            exampleBhojpuri = "इहाँ से रेलवे स्टेशन कतेक दूर बा?",
            examplePhonetic = "Ihaan se railway station katek door ba?",
            exampleNepali = "यहाँबाट रेलवे स्टेसन कति टाढा छ?",
            exampleEnglish = "How far is the railway station from here?"
        ),
        VocabularyItem(
            id = "tr2",
            bhojpuri = "सोझे जाईं",
            phonetic = "Sojhe jaai",
            nepali = "सिधा जानुहोस्",
            english = "Go straight ahead",
            bhojpuriMeaning = "एकदम सीधा रास्ता पर चलल",
            category = WordCategory.TRAVEL,
            exampleBhojpuri = "सोझे जाईं, चौक मिल जाई।",
            examplePhonetic = "Sojhe jaai, chawk mil jaai.",
            exampleNepali = "सिधा जानुहोस्, चोक भेटिनेछ।",
            exampleEnglish = "Go straight, you will find the intersection."
        ),
        VocabularyItem(
            id = "tr3",
            bhojpuri = "बाएं / दाएं मुड़ीं",
            phonetic = "Baayein / Daayein mudeen",
            nepali = "देब्रे / दाहिने मोडिनुहोस्",
            english = "Turn Left / Turn Right",
            bhojpuriMeaning = "रास्ता के दिशा में मुड़ल",
            category = WordCategory.TRAVEL,
            exampleBhojpuri = "मंदिर के लगे से दाएं मुड़ीं।",
            examplePhonetic = "Mandir ke lage se daayein mudeen.",
            exampleNepali = "मन्दिर नजिकैबाट दाहिने मोडिनुहोस्।",
            exampleEnglish = "Turn right near the temple."
        ),
        VocabularyItem(
            id = "tr4",
            bhojpuri = "कहाँ जात बानी?",
            phonetic = "Kahaan jaat baani?",
            nepali = "कहाँ जाँदै हुनुहुन्छ?",
            english = "Where are you going?",
            bhojpuriMeaning = "कवनो व्यक्ति के गंतव्य पूछल",
            category = WordCategory.TRAVEL,
            exampleBhojpuri = "रउआ एतने सबेरे कहाँ जात बानी?",
            examplePhonetic = "Rauaa etne sabere kahaan jaat baani?",
            exampleNepali = "हजुर यति बिहानै कहाँ जाँदै हुनुहुन्छ?",
            exampleEnglish = "Where are you going so early in the morning?"
        )
    )

    val lessons = listOf(
        Lesson(
            id = "l1",
            levelNumber = 1,
            titleBhojpuri = "प्रणाम अउर शिष्टाचार",
            titleNepali = "अभिवादन र शिष्टाचार",
            titleEnglish = "Greetings & Courtesies",
            descriptionBhojpuri = "प्रणाम, गोड़ लागतानी, हालचाल अउर मीठ बोली सीखल जाव।",
            descriptionNepali = "नमस्ते, ढोगेँ, हालखबर र आदरार्थी सम्बोधन सिक्नुहोस्।",
            descriptionEnglish = "Master respectful greetings, courtesies, and asking how someone is.",
            icon = "🙏",
            vocabularyIds = listOf("g1", "g2", "g3", "g4", "g5", "g6", "g7", "g8"),
            grammarTipBhojpuri = "बड़का लोग के हमेशा 'रउआ' कह के 'बानी' लगा के बात करीं। छोट लोग खातिर 'तू' बा।",
            grammarTipNepali = "ठूला मानिसलाई सधैँ 'रउआ' भनी 'बानी' जोड्नुपर्छ। साथीभाइ वा सानालाई 'तू' भनिन्छ।",
            grammarTipEnglish = "Always use 'रउआ' (Rauaa) with verb ending '-बानी' (baani) for respect. Use 'तू' (Tu) for friends."
        ),
        Lesson(
            id = "l2",
            levelNumber = 2,
            titleBhojpuri = "सर्वनाम अउर आदर के स्तर",
            titleNepali = "सर्वनाम र आदरको तह",
            titleEnglish = "Pronouns & Politeness Levels",
            descriptionBhojpuri = "हम, हमनी, रउआ, तू, अपने अउर संबंधक शब्द।",
            descriptionNepali = "म, हामी, तपाईं, तिमी, हजुर र सम्बन्ध बुझाउने शब्दहरू।",
            descriptionEnglish = "Learn Bhojpuri personal pronouns and cultural honorific hierarchy.",
            icon = "👥",
            vocabularyIds = listOf("p1", "p2", "p3", "p4", "p5", "p6"),
            grammarTipBhojpuri = "'हम' माने 'म' (I) होला। 'हमनी के' माने 'हामीहरू' (We)।",
            grammarTipNepali = "भोजपुरीमा 'हम' को अर्थ 'म' हुन्छ। 'हमनी के' भन्नाले 'हामीहरू' बुझिन्छ।",
            grammarTipEnglish = "'हम' (Hum) means singular 'I'. To say 'we', use 'हमनी के' (Hamani ke)."
        ),
        Lesson(
            id = "l3",
            levelNumber = 3,
            titleBhojpuri = "गिनती १ से १०० तक",
            titleNepali = "गन्ती १ देखि १०० सम्म",
            titleEnglish = "Numbers & Counting",
            descriptionBhojpuri = "एक, दु, तीन, बीस, पचास, सौ - भोजपुरी में संख्या।",
            descriptionNepali = "एक, दुई, तीन, बीस, पचास, सय - भोजपुरी सङ्ख्या गणना।",
            descriptionEnglish = "Count seamlessly from 1 to 100 in authentic Bhojpuri accent.",
            icon = "🔢",
            vocabularyIds = listOf("n1", "n2", "n3", "n4", "n5", "n6"),
            grammarTipBhojpuri = "संख्या के पाछे 'गो' लगावल जाला जइसे: 'दु गो चाय', 'पाँच गो आम'।",
            grammarTipNepali = "सङ्ख्याको पछाडि 'गो' (वटा) जोडिन्छ, जस्तै: 'दु गो चिया' (दुई वटा चिया)।",
            grammarTipEnglish = "Add the counter 'गो' (go) after numbers, e.g. 'दु गो' (two items), 'पाँच गो' (five items)."
        ),
        Lesson(
            id = "l4",
            levelNumber = 4,
            titleBhojpuri = "हमार प्यारा परिवार",
            titleNepali = "मेरो प्यारो परिवार",
            titleEnglish = "Family & Kinship",
            descriptionBhojpuri = "माई, बाबूजी, भईया, भौजी, बहिन, बबुआ - नाता-गोता।",
            descriptionNepali = "आमा, बुबा, दाइ, भाउजू, बहिनी, बाबु - पारिवारिक साइनो।",
            descriptionEnglish = "Learn kinship terms and addressing family members with love.",
            icon = "👨‍👩‍👧‍👦",
            vocabularyIds = listOf("f1", "f2", "f3", "f4", "f5", "f6", "f7"),
            grammarTipBhojpuri = "परिवार में बड़का के आदर देवे खातिर क्रिया में '-लन' भा '-लिन' लागी जइसे 'अईलन'।",
            grammarTipNepali = "परिवारमा ठूलाबडाको सम्मानका लागि क्रियामा '-लन' वा '-लिन' जोडिन्छ।",
            grammarTipEnglish = "Honorific verbs for family elders end in '-लन' (lan) or '-लीन' (leen)."
        ),
        Lesson(
            id = "l5",
            levelNumber = 5,
            titleBhojpuri = "खान-पान अउर स्वाद",
            titleNepali = "खान-पान र स्वाद",
            titleEnglish = "Food, Cuisine & Tastes",
            descriptionBhojpuri = "लिट्टी चोखा, भात दाल भुजिया, ठेकुआ, चाहा अउर पानी।",
            descriptionNepali = "लिट्टी चोखा, दाल-भात-भुजिया, ठेकुवा र चिया।",
            descriptionEnglish = "Explore authentic Bhojpuri food culture and dining phrases.",
            icon = "🍲",
            vocabularyIds = listOf("fd1", "fd2", "fd3", "fd4", "fd5"),
            grammarTipBhojpuri = "खाना खाए के आग्रह करत घरी 'रउआ भोजन करीं' भा 'खाईं' कहल जाला।",
            grammarTipNepali = "खाना खान अनुरोध गर्दा 'खाईं' वा 'भोजन करीं' भनिन्छ।",
            grammarTipEnglish = "Offer food politely with 'खाईं' (Khaai - please eat) or 'लीजहीं' (Pleease take)."
        ),
        Lesson(
            id = "l6",
            levelNumber = 6,
            titleBhojpuri = "रोजमर्रा के क्रिया (Verbs)",
            titleNepali = "दैनिक क्रियापदहरू",
            titleEnglish = "Essential Daily Verbs",
            descriptionBhojpuri = "खाएब, जाएब, आवेब, बोलेब, बुझेब, सूतेब।",
            descriptionNepali = "खानु, जानु, आउनु, बोल्नु, बुझ्नु, सुत्नु।",
            descriptionEnglish = "Master verb roots and daily action conjugations.",
            icon = "⚡",
            vocabularyIds = listOf("v1", "v2", "v3", "v4", "v5", "v6"),
            grammarTipBhojpuri = "वर्तमान काल में 'तानी' (I am doing) अउर भविष्य में 'ईब' (I will do) जुडेला।",
            grammarTipNepali = "वर्तमान कालमा '-तानी' (गर्दैछु) र भविष्यमा '-ईब' (गर्नेछु) जोडिन्छ।",
            grammarTipEnglish = "Present continuous uses '-तानी' (e.g. खातानी) and future uses '-ईब' (खाईब)."
        ),
        Lesson(
            id = "l7",
            levelNumber = 7,
            titleBhojpuri = "बजार अउर मोल-भाव",
            titleNepali = "बजार र मोलतोल",
            titleEnglish = "Market Bargaining & Shopping",
            descriptionBhojpuri = "एकर का दाम बा?, तनिक कम करीं ना!, सस्ता, ताजा।",
            descriptionNepali = "कति पर्छ?, अलिकति घटाउनुस्!, सस्तो, ताजा।",
            descriptionEnglish = "Bargain smoothly in local markets and shops.",
            icon = "🛍️",
            vocabularyIds = listOf("m1", "m2", "m3", "m4"),
            grammarTipBhojpuri = "मोलभाव में 'तनिक' (अलिकति) अउर 'ना' लगावे से बात नम्र हो जाला।",
            grammarTipNepali = "'तनिक' (अलिकति) शब्दले कुराकानीलाई निकै नम्र र मिठासपूर्ण बनाउँछ।",
            grammarTipEnglish = "Use 'तनिक' (Tanik - a little bit) to soften your bargaining requests pleasantly."
        ),
        Lesson(
            id = "l8",
            levelNumber = 8,
            titleBhojpuri = "यात्रा अउर दिशा",
            titleNepali = "यात्रा र बाटो",
            titleEnglish = "Travel & Navigation",
            descriptionBhojpuri = "कतेक दूर बा?, सोझे जाईं, बाएं-दाएं मुड़ीं, कहाँ जात बानी?",
            descriptionNepali = "कति टाढा छ?, सिधा जानुहोस्, देब्रे-दाहिने, कहाँ जाँदै हुनुहुन्छ?",
            descriptionEnglish = "Ask for directions and navigate towns and villages with confidence.",
            icon = "🚶",
            vocabularyIds = listOf("tr1", "tr2", "tr3", "tr4"),
            grammarTipBhojpuri = "'सोझे' माने एकदम सीधा (Straight)। 'कतेक' माने कति (How much / how far)।",
            grammarTipNepali = "'सोझे' भन्नाले सिधा र 'कतेक' भन्नाले कति भन्ने बुझाउँछ।",
            grammarTipEnglish = "'सोझे' (Sojhe) means straight ahead. 'कतेक' (Katek) means how much/far."
        )
    )

    val proverbs = listOf(
        ProverbItem(
            id = "pr1",
            bhojpuri = "नाच न जाने आँगन टेढ़",
            phonetic = "Naach na jaane aangan tedh",
            literalMeaningBhojpuri = "नाचे के हुनर नईखे त आँगन के दोष देहल",
            nepaliEquivalent = "नाच्न नजान्ने आँगन टेढो",
            englishEquivalent = "A bad workman blames his tools",
            explanationBhojpuri = "जब केहू में हुनर ना रहेला त ऊ माहौल या साधन के गलती निकाले लागेला।",
            explanationNepali = "आफूमा क्षमता नहुँदा परिस्थिति वा अरूलाई दोष लगाउने प्रवृत्ति।",
            explanationEnglish = "Used when someone lacks skill and blames the surroundings or equipment."
        ),
        ProverbItem(
            id = "pr2",
            bhojpuri = "घर के मुर्गी दाल बराबर",
            phonetic = "Ghar ke murgi daal baraabar",
            literalMeaningBhojpuri = "अपन घरे उपलब्ध नीमन चीजो के कदर ना करल",
            nepaliEquivalent = "घरको कुखुरा दाल बराबर",
            englishEquivalent = "Familiarity breeds contempt",
            explanationBhojpuri = "जे चीज आसानी से घरे मिल जाला, ओकर मोल लोग ना समझेला।",
            explanationNepali = "सजिलै उपलब्ध हुने महत्वपूर्ण चिजको उचित मूल्याङ्कन नगर्नु।",
            explanationEnglish = "Valuable things easily available at home are often taken for granted."
        ),
        ProverbItem(
            id = "pr3",
            bhojpuri = "अन्हरा में काना राजा",
            phonetic = "Anhara me kaana raaja",
            literalMeaningBhojpuri = "अन्धा लोग के बीच में एक आँख वाला पूजनीय हो जाला",
            nepaliEquivalent = "अन्धामा काना राजा",
            englishEquivalent = "In the land of the blind, the one-eyed man is king",
            explanationBhojpuri = "मूरख लोगन के बीच में तनिक कम जनलकारो आदमी विद्वान मानल जाला।",
            explanationNepali = "अज्ञानीहरूको बीचमा थोरै जान्ने मानिस पनि ठूलो कहलिन्छ।",
            explanationEnglish = "A person with modest ability shines among those who have none."
        ),
        ProverbItem(
            id = "pr4",
            bhojpuri = "दुधारू गाय के लातो सहल जाला",
            phonetic = "Dudhaaru gaay ke laato sahal jaala",
            literalMeaningBhojpuri = "दूध देवे वाली गैया अगर लात मारे त ओकरा सह लिहल जाला",
            nepaliEquivalent = "दूध दिने गाईको लात पनि सहिन्छ",
            englishEquivalent = "You put up with temper from those who benefit you",
            explanationBhojpuri = "जेकरा से फायदा होखेला, ओकर कड़ुआ बात भा नखरा भी लोग सह लेवेला।",
            explanationNepali = "जसबाट निरन्तर लाभ भइरहन्छ, उसको सानोतिनो नराम्रो बानी पनि सहिन्छ।",
            explanationEnglish = "One tolerates rough behavior or inconvenience from someone who provides great value."
        ),
        ProverbItem(
            id = "pr5",
            bhojpuri = "जइसन बोईब तइसन लूनी",
            phonetic = "Jaisan boib taisan looni",
            literalMeaningBhojpuri = "जइसन फसल रोपब, वइसने काटे के मिली",
            nepaliEquivalent = "जस्तो रोप्छौ, त्यस्तै पाउँछौ",
            englishEquivalent = "As you sow, so shall you reap",
            explanationBhojpuri = "इंसान जइसन कर्म करेला, ओकर फल भी वइसने मिलेला।",
            explanationNepali = "मानिसले आफ्नो कर्म अनुसार नै जीवनमा फल प्राप्त गर्दछ।",
            explanationEnglish = "Your deeds will determine your eventual consequences."
        ),
        ProverbItem(
            id = "pr6",
            bhojpuri = "हथिया बीतल, पूँछ लटकल",
            phonetic = "Hathiya beetal, poonchh latkal",
            literalMeaningBhojpuri = "पूरन हाथी निकल गइल, बस पूँछ अटकल बा",
            nepaliEquivalent = "हात्ती छिर्यो, पुच्छर अड्कियो",
            englishEquivalent = "Almost completed, but stumbling at the very finish line",
            explanationBhojpuri = "बड़ा काम पूरा हो गइल बाकिर छोटहन काम अटकल बा।",
            explanationNepali = "धेरैजसो ठूलो काम सम्पन्न भयो तर अन्तिम सानो कुरामा ढिलाइ हुनु।",
            explanationEnglish = "The major difficult task is finished, but minor loose ends linger."
        )
    )

    val dialogues = listOf(
        ConversationDialogue(
            id = "dia1",
            titleBhojpuri = "गाँव के राह में काका से भेंट",
            titleNepali = "गाउँको बाटोमा काकासँग भेट",
            titleEnglish = "Meeting Uncle on the Village Path",
            scenarioBhojpuri = "सुबेरे खेत जाए के घरी रास्ता में काका से प्रणाम-पाती अउर बातचीत।",
            scenarioNepali = "बिहान खेत जाने क्रममा बाटोमा काकासँग भलाकुसारी र आदर।",
            scenarioEnglish = "A respectful morning encounter with an elder neighbor on the village trail.",
            icon = "🌾",
            lines = listOf(
                DialogueLine(
                    speaker = "Rahul",
                    speakerTitleBhojpuri = "राहुल",
                    speakerTitleNepali = "राहुल",
                    speakerTitleEnglish = "Rahul",
                    bhojpuri = "प्रणाम काका! गोड़ लागतानी।",
                    phonetic = "Pranaam Kaaka! Gor laagataani.",
                    nepali = "नमस्कार काका! गोडा ढोगेँ।",
                    english = "Greetings Uncle! Touching your feet with respect.",
                    isPrimarySpeaker = true
                ),
                DialogueLine(
                    speaker = "Uncle",
                    speakerTitleBhojpuri = "काका",
                    speakerTitleNepali = "काका",
                    speakerTitleEnglish = "Uncle",
                    bhojpuri = "खुश रहऽ बबुआ! जुग-जुग जियऽ। कहाँ जात बाड़ऽ?",
                    phonetic = "Khush raha babua! Jug-jug jiya. Kahaan jaat baada?",
                    nepali = "बाँचिरह बाबु! दीर्घायु होऊ। कहाँ जाँदैछौ?",
                    english = "Bless you son! Live long. Where are you heading?",
                    isPrimarySpeaker = false
                ),
                DialogueLine(
                    speaker = "Rahul",
                    speakerTitleBhojpuri = "राहुल",
                    speakerTitleNepali = "राहुल",
                    speakerTitleEnglish = "Rahul",
                    bhojpuri = "हम खेत पर जात बानी। बाबूजी के नाश्ता पहुँचावे के बा।",
                    phonetic = "Hum khet par jaat baani. Baabooji ke naashta pahunchaawe ke ba.",
                    nepali = "म खेततिर जाँदैछु। बुबालाई खाजा पुर्याउनु छ।",
                    english = "I am going to the farm. I need to deliver breakfast to Father.",
                    isPrimarySpeaker = true
                ),
                DialogueLine(
                    speaker = "Uncle",
                    speakerTitleBhojpuri = "काका",
                    speakerTitleNepali = "काका",
                    speakerTitleEnglish = "Uncle",
                    bhojpuri = "बड़ा नीमन! जा, बाबूजी के कहिहऽ साँझ के घरे आवे खातिर।",
                    phonetic = "Bada neeman! Jaa, baabooji ke kahiha saanjh ke ghare aawe khaatir.",
                    nepali = "धेरै राम्रो! जाऊ, बुबालाई साँझमा घर आउन भनिदिनू।",
                    english = "Very nice! Go ahead, and tell your father to come over in the evening.",
                    isPrimarySpeaker = false
                ),
                DialogueLine(
                    speaker = "Rahul",
                    speakerTitleBhojpuri = "राहुल",
                    speakerTitleNepali = "राहुल",
                    speakerTitleEnglish = "Rahul",
                    bhojpuri = "हँ काका, जरूर कह देब। फेरु भेंट होई!",
                    phonetic = "Haan Kaaka, jaroor kah deb. Pheru bhent hoi!",
                    nepali = "हुन्छ काका, अवश्य भनिदिन्छु। फेरि भेटौँला!",
                    english = "Yes Uncle, I will definitely tell him. See you again!",
                    isPrimarySpeaker = true
                )
            )
        ),
        ConversationDialogue(
            id = "dia2",
            titleBhojpuri = "चाय के दोकान पर",
            titleNepali = "चिया पसलमा",
            titleEnglish = "At the Local Tea Stall",
            scenarioBhojpuri = "चौक के दोकान पर कड़क चाय अउर समोसा मंगवल।",
            scenarioNepali = "चोकको पसलमा कडा चिया र समोसा अर्डर गर्दा।",
            scenarioEnglish = "Ordering refreshing ginger tea and snacks at a lively street corner stall.",
            icon = "☕",
            lines = listOf(
                DialogueLine(
                    speaker = "Customer",
                    speakerTitleBhojpuri = "ग्राहक",
                    speakerTitleNepali = "ग्राहक",
                    speakerTitleEnglish = "Customer",
                    bhojpuri = "भईया, एक कुल्हड़ बढ़िया कड़क चाय बनावीं ना!",
                    phonetic = "Bhaiya, ek kulhad badhiya kadak chaay banaaveen naa!",
                    nepali = "दाइ, एक कप मिठो कडा चिया बनाउनुहोस् न!",
                    english = "Brother, please brew a nice strong cup of clay-pot tea!",
                    isPrimarySpeaker = true
                ),
                DialogueLine(
                    speaker = "Shopkeeper",
                    speakerTitleBhojpuri = "दुकानदार",
                    speakerTitleNepali = "साहुजी",
                    speakerTitleEnglish = "Shopkeeper",
                    bhojpuri = "अदरक डालब कि इलायची बाबू?",
                    phonetic = "Adarak daalab ki ilaayachi baabu?",
                    nepali = "अदुवा हाल्ने कि सुकुमेल बाबु?",
                    english = "Should I add ginger or cardamom, young man?",
                    isPrimarySpeaker = false
                ),
                DialogueLine(
                    speaker = "Customer",
                    speakerTitleBhojpuri = "ग्राहक",
                    speakerTitleNepali = "ग्राहक",
                    speakerTitleEnglish = "Customer",
                    bhojpuri = "अदरक डाल के तनिक चीनी कम रखब।",
                    phonetic = "Adarak daal ke tanik cheeni kam rakhab.",
                    nepali = "अदुवा हालेर अलिकति चिनी कम राख्नुस्।",
                    english = "Add ginger and please keep the sugar a little low.",
                    isPrimarySpeaker = true
                ),
                DialogueLine(
                    speaker = "Shopkeeper",
                    speakerTitleBhojpuri = "दुकानदार",
                    speakerTitleNepali = "साहुजी",
                    speakerTitleEnglish = "Shopkeeper",
                    bhojpuri = "गरम समोसा भी छनता, लिहल जाई?",
                    phonetic = "Garam samosa bhi chhaanata, lihal jaai?",
                    nepali = "तातो समोसा पनि पाक्दैछ, लिनुहुन्छ?",
                    english = "Hot samosas are also being fried, would you like one?",
                    isPrimarySpeaker = false
                ),
                DialogueLine(
                    speaker = "Customer",
                    speakerTitleBhojpuri = "ग्राहक",
                    speakerTitleNepali = "ग्राहक",
                    speakerTitleEnglish = "Customer",
                    bhojpuri = "हँ, दु गो समोसा भी दे दीं। कुल कतेक रूपिया भइल?",
                    phonetic = "Haan, du go samosa bhi de deen. Kul katek rupiya bhail?",
                    nepali = "हुन्छ, दुई वटा समोसा पनि दिनुहोस्। जम्मा कति रुपैयाँ भयो?",
                    english = "Yes, give two samosas as well. How much is the total?",
                    isPrimarySpeaker = true
                )
            )
        ),
        ConversationDialogue(
            id = "dia3",
            titleBhojpuri = "सब्जी मंडी में मोल-भाव",
            titleNepali = "तरकारी बजारमा मोलतोल",
            titleEnglish = "Bargaining at the Fresh Vegetable Market",
            scenarioBhojpuri = "आलू, गोभी अउर टमाटर के भाव-ताव अउर दाम कम करवावल।",
            scenarioNepali = "आलु, काउली र गोलभेँडाको भाउ सोध्ने र मोलतोल गर्ने।",
            scenarioEnglish = "Negotiating prices for fresh farm vegetables with the vendor.",
            icon = "🍅",
            lines = listOf(
                DialogueLine(
                    speaker = "Shopper",
                    speakerTitleBhojpuri = "खरीदार",
                    speakerTitleNepali = "ग्राहक",
                    speakerTitleEnglish = "Shopper",
                    bhojpuri = "साहुजी, टमाटर कइसे किलो देले बानी?",
                    phonetic = "Saahuji, tamaatar kaise kilo dele baani?",
                    nepali = "साहुजी, गोलभेँडा कसरी किलो दिँदै हुनुहुन्छ?",
                    english = "Shopkeeper, how much per kilo for the tomatoes?",
                    isPrimarySpeaker = true
                ),
                DialogueLine(
                    speaker = "Vendor",
                    speakerTitleBhojpuri = "सब्जीवाला",
                    speakerTitleNepali = "तरकारी व्यापारी",
                    speakerTitleEnglish = "Vendor",
                    bhojpuri = "चालीस रूपिया किलो बा बबुआ, एकदम खेत के ताजा!",
                    phonetic = "Chaalis rupiya kilo ba babua, ekdam khet ke taaja!",
                    nepali = "चालीस रुपैयाँ किलो हो बाबु, एकदम खेतको ताजा!",
                    english = "Forty rupees a kilo son, fresh straight from the field!",
                    isPrimarySpeaker = false
                ),
                DialogueLine(
                    speaker = "Shopper",
                    speakerTitleBhojpuri = "खरीदार",
                    speakerTitleNepali = "ग्राहक",
                    speakerTitleEnglish = "Shopper",
                    bhojpuri = "तनिक बेसी कहत बानी, तीस रूपिया में दीं त दु किलो लेम।",
                    phonetic = "Tanik besi kahat baani, tees rupiya me deen ta du kilo lem.",
                    nepali = "अलि धेरै भन्नुभयो, तीस रुपैयाँमा दिनुभयो भने दुई किलो लिन्छु।",
                    english = "That's a bit high, give it for thirty and I'll buy two kilos.",
                    isPrimarySpeaker = true
                ),
                DialogueLine(
                    speaker = "Vendor",
                    speakerTitleBhojpuri = "सब्जीवाला",
                    speakerTitleNepali = "तरकारी व्यापारी",
                    speakerTitleEnglish = "Vendor",
                    bhojpuri = "चलीं राउर बात राखल जाव, पैंतीस में दु किलो तौल देतानी।",
                    phonetic = "Chaleen raaur baat raakhal jaav, paintees me du kilo taul detaani.",
                    nepali = "ल हजुरको कुरा राखौँ, पैंतीसमा दुई किलो जोखी दिन्छु।",
                    english = "Alright I'll honor your word, weighing two kilos at thirty-five.",
                    isPrimarySpeaker = false
                )
            )
        )
    )

    val grammarTopics = listOf(
        GrammarTopic(
            id = "gt1",
            titleBhojpuri = "आदर के तीन स्तर (तू, रउआ, अपने)",
            titleNepali = "आदरका तीन तहहरू (तू, रउआ, अपने)",
            titleEnglish = "Three Levels of Politeness in Bhojpuri",
            ruleBhojpuri = "भोजपुरी में तीन तरह से 'तू' कहल जाला: ১. तू (मित्र अउर छोट खातिर) २. रउआ (सामान्य सम्मान अउर बड़का लोग खातिर) ३. अपने (साधु, बुजुर्ग अउर गुरुजन खातिर अति आदर)।",
            ruleNepali = "भोजपुरी भाषामा तीन तहको आदर पाइन्छ: १. तू (साथीभाइ र सानालाई) २. रउआ (तपाईँ / सामान्य आदरार्थी) ३. अपने (हजुर / उच्च आदरार्थी)।",
            ruleEnglish = "Bhojpuri uses 3 levels of address: 1. तू (Tu - informal/intimate), 2. रउआ (Rauaa - polite/elders), 3. अपने (Apne - honorific/formal guests).",
            icon = "👑",
            examples = listOf(
                GrammarExample("तू कहाँ जात बाड़ऽ?", "Tu kahaan jaat baada?", "तिमी कहाँ जाँदैछौ?", "Where are you going? (Informal)"),
                GrammarExample("रउआ कहाँ जात बानी?", "Rauaa kahaan jaat baani?", "तपाईँ कहाँ जाँदै हुनुहुन्छ?", "Where are you going? (Polite)"),
                GrammarExample("अपने कहाँ पधारत बानी?", "Apne kahaan padhaarat baani?", "हजुर कहाँ सवारी हुँदै हुनुहुन्छ?", "Where are you gracefully headed? (Honorific)")
            )
        ),
        GrammarTopic(
            id = "gt2",
            titleBhojpuri = "वर्तमान काल के क्रिया (बानी / बा / बाटें)",
            titleNepali = "वर्तमान कालका क्रियापदहरू (बानी / बा / बाटें)",
            titleEnglish = "Present Tense 'To Be' & Continuous Action",
            ruleBhojpuri = "पहिलका पुरुष (हम) अउर आदरणीय (रउआ) के साथे 'बानी' लागेला। अन्य पुरुष (ऊ / ई) खातिर 'बा' भा 'बाटे' लागेला।",
            ruleNepali = "पहिलो पुरुष (म) र आदरार्थी (तपाईँ) मा 'बानी' (छु / हुनुहुन्छ) लाग्छ। ऊ/यो मा 'बा' (छ) जोडिन्छ।",
            ruleEnglish = "For 'I' (हम) and polite 'You' (रउआ), use 'बानी' (baani). For 'He/She/It' (ऊ/ई), use 'बा' (ba) or 'बाटे' (baate).",
            icon = "⏳",
            examples = listOf(
                GrammarExample("हम ठीक बानी।", "Hum theek baani.", "म ठीक छु।", "I am fine."),
                GrammarExample("रउआ कइसे बानी?", "Rauaa kaise baani?", "तपाईँ कस्तो हुनुहुन्छ?", "How are you?"),
                GrammarExample("पानी बहुत शीतल बा।", "Paani bahut sheetal ba.", "पानी धेरै चिसो छ।", "The water is very cold.")
            )
        ),
        GrammarTopic(
            id = "gt3",
            titleBhojpuri = "भोजपुरी प्रत्यय (-वे, -वा, -बा)",
            titleNepali = "भोजपुरी प्रत्ययहरू (-वे, -वा, -बा)",
            titleEnglish = "Characteristic Bhojpuri Suffixes & Enclitics",
            ruleBhojpuri = "भोजपुरी भाषा में शब्द के खास बनावे खातिर संज्ञा के अंत में '-वा' (लइका -> लइकवा, घर -> घरवा) भा जोर देवे खातिर '-वे' लागेला।",
            ruleNepali = "कुनै वस्तु वा व्यक्तिलाई तोकेर वा आत्मीयता देखाउन पछाडि '-वा' (जस्तै: लइकाबाट लइकवा, घरबाट घरवा) जोडिन्छ।",
            ruleEnglish = "Bhojpuri uses expressive enclitic suffixes like '-वा' (-wa) for familiarity or focus, e.g. लइका (boy) -> लइकवा (that particular boy).",
            icon = "✨",
            examples = listOf(
                GrammarExample("ऊ लइकवा बड़ा होशियार बा।", "Oo laikwa bada hoshiyaar ba.", "त्यो केटो धेरै चनाखो छ।", "That boy is very smart."),
                GrammarExample("हमार घरवे ई हवे।", "Hamaar gharve ee have.", "मेरो घर नै यही हो।", "This indeed is my very house.")
            )
        ),
        GrammarTopic(
            id = "gt4",
            titleBhojpuri = "भविष्य काल (जाईब / खाईब / करीब)",
            titleNepali = "भविष्य काल (जानेछु / खानेछु / गर्नेछु)",
            titleEnglish = "Future Tense ('Will do')",
            ruleBhojpuri = "भविष्य के बात कहे खातिर क्रिया के पाछे '-ईब' भा '-एम' जुडेला। जइसे: खाएब -> खाईब, जाएब -> जाईब।",
            ruleNepali = "भविष्य काल बुझाउन क्रियापदमा '-ईब' वा '-एम' जोडिन्छ। जस्तै: खाईब (खानेछु), जाईब (जानेछु)।",
            ruleEnglish = "To express future actions, the suffix '-ईब' (-eeb) or '-एम' (-aem) is affixed to the verb root.",
            icon = "🚀",
            examples = listOf(
                GrammarExample("हम काल्हि जनकपुर जाईब।", "Hum kaalhi Janakpur jaaib.", "म भोलि जनकपुर जानेछु।", "I will go to Janakpur tomorrow."),
                GrammarExample("हमनी के साथे भात खाईब।", "Hamani ke saathe bhaat khaaib.", "हामी सँगै भात खानेछौँ।", "We will eat rice together.")
            )
        )
    )

    val quizzes = listOf(
        QuizItem(
            id = "q1",
            type = QuizType.MULTIPLE_CHOICE,
            promptBhojpuri = "'रउआ कइसे बानी?' के अर्थ का होला?",
            promptNepali = "'रउआ कइसे बानी?' को अर्थ के हुन्छ?",
            promptEnglish = "What is the meaning of 'रउआ कइसे बानी?'",
            targetAudioText = "रउआ कइसे बानी?",
            correctAnswer = "How are you? (Polite)",
            options = listOf("Where are you going?", "How are you? (Polite)", "What did you eat?", "Who are you?"),
            explanationBhojpuri = "'रउआ' माने आदरणीय रउआ अउर 'कइसे बानी' माने कस्तो हुनुहुन्छ।",
            explanationNepali = "'रउआ' भनेको 'तपाईँ' र 'कइसे बानी' भनेको 'कस्तो हुनुहुन्छ' हो।",
            explanationEnglish = "'रउआ' means 'you (polite)' and 'कइसे बानी' means 'how are you'."
        ),
        QuizItem(
            id = "q2",
            type = QuizType.MULTIPLE_CHOICE,
            promptBhojpuri = "भोजपुरी में 'माई' के का कहल जाला?",
            promptNepali = "भोजपुरीमा 'माई' भन्नाले कसलाई बुझिन्छ?",
            promptEnglish = "Who does 'माई' refer to in Bhojpuri?",
            targetAudioText = "माई",
            correctAnswer = "Mother",
            options = listOf("Sister", "Mother", "Aunt", "Daughter"),
            explanationBhojpuri = "भोजपुरी में माता जी के प्रेम से 'माई' भा 'महतारी' कहल जाला।",
            explanationNepali = "भोजपुरीमा आमालाई आदरका साथ 'माई' भनिन्छ।",
            explanationEnglish = "'माई' (Maai) lovingly refers to Mother in Bhojpuri."
        ),
        QuizItem(
            id = "q3",
            type = QuizType.SENTENCE_BUILDER,
            promptBhojpuri = "क्रम से लगा के वाक्य बनावीं: 'I am learning Bhojpuri'",
            promptNepali = "शब्दहरू मिलाएर वाक्य बनाउनुहोस्: 'म भोजपुरी सिक्दैछु'",
            promptEnglish = "Arrange the words in order: 'I am learning Bhojpuri'",
            targetAudioText = "हम भोजपुरी सीखतानी",
            correctAnswer = "हम भोजपुरी सीखतानी",
            scrambledWords = listOf("सीखतानी", "हम", "भोजपुरी"),
            explanationBhojpuri = "सही वाक्य: 'हम भोजपुरी सीखतानी।' (Hum Bhojpuri seekhtaani)",
            explanationNepali = "सही वाक्य: 'हम भोजपुरी सीखतानी।' (म भोजपुरी सिक्दैछु)",
            explanationEnglish = "Correct order: 'हम' (I) + 'भोजपुरी' (Bhojpuri) + 'सीखतानी' (am learning)."
        ),
        QuizItem(
            id = "q4",
            type = QuizType.MULTIPLE_CHOICE,
            promptBhojpuri = "दुकानदार से दाम पूछे खातिर कवन वाक्य बोलल जाला?",
            promptNepali = "पसलमा मूल्य सोध्न कुन वाक्य बोलिन्छ?",
            promptEnglish = "Which phrase is used to ask for the price?",
            targetAudioText = "एकर का दाम बा?",
            correctAnswer = "एकर का दाम बा?",
            options = listOf("एकर का दाम बा?", "कहाँ जात बानी?", "हम ठीक बानी", "काका गोड़ लागतानी"),
            explanationBhojpuri = "'एकर का दाम बा?' माने एकर कति मूल्य हो।",
            explanationNepali = "'एकर का दाम बा?' भन्नाले यसको कति मूल्य हो भन्ने बुझाउँछ।",
            explanationEnglish = "'एकर का दाम बा?' directly translates to 'How much does this cost?'."
        ),
        QuizItem(
            id = "q5",
            type = QuizType.SENTENCE_BUILDER,
            promptBhojpuri = "क्रम से लगावीं: 'Where are you going? (Polite)'",
            promptNepali = "क्रम मिलाउनुहोस्: 'तपाईँ कहाँ जाँदै हुनुहुन्छ?'",
            promptEnglish = "Arrange the words: 'Where are you going? (Polite)'",
            targetAudioText = "रउआ कहाँ जात बानी",
            correctAnswer = "रउआ कहाँ जात बानी",
            scrambledWords = listOf("कहाँ", "बानी", "रउआ", "जात"),
            explanationBhojpuri = "सही वाक्य: 'रउआ कहाँ जात बानी?'",
            explanationNepali = "सही वाक्य: 'रउआ कहाँ जात बानी?' (तपाईँ कहाँ जाँदै हुनुहुन्छ?)",
            explanationEnglish = "Correct syntax: 'रउआ' (You) + 'कहाँ' (where) + 'जात' (going) + 'बानी' (are)."
        ),
        QuizItem(
            id = "q6",
            type = QuizType.LISTENING,
            promptBhojpuri = "आवाज सुनीं अउर सही जवाब चुनीं!",
            promptNepali = "आवाज सुन्नुहोस् र सही उत्तर रोज्नुहोस्!",
            promptEnglish = "Listen to the audio and choose the correct meaning!",
            targetAudioText = "गोड़ लागतानी",
            correctAnswer = "I touch your feet with respect",
            options = listOf("I touch your feet with respect", "Give me water", "I will sleep now", "See you tomorrow"),
            explanationBhojpuri = "'गोड़ लागतानी' बुजुर्गन के चरण स्पर्श करे के आदरणीय वाक्य हवे।",
            explanationNepali = "'गोड़ लागतानी' अग्रजको चरण स्पर्श गरी ढोग्ने आदरार्थी शब्द हो।",
            explanationEnglish = "'गोड़ लागतानी' literally means 'I touch your feet' (traditional high respect)."
        )
    )

    val culturalHighlights = listOf(
        Triple(
            "छठ पूजा (महापर्व)",
            "Chhath Puja is the greatest festival of the Bhojpuri region (Purvanchal & Nepal Terai). Dedicated to the Sun God (सूर्य) and Chhathi Maiya, it celebrates purity, nature, unity without caste discrimination, and the sacred offering of Thekua.",
            "छठ पूजा भोजपुरी र मधेश-तराई क्षेत्रको महान् लोकपर्व हो। यसमा उदाउँदो र अस्ताउँदो सूर्यलाई अर्घ्य दिएर पवित्रता, समता र कृतज्ञता प्रकट गरिन्छ।"
        ),
        Triple(
            "भिखारी ठाकुर (भोजपुरी के शेक्सपियर)",
            "Bhikhari Thakur (1887–1971) is reverently known as the 'Shakespeare of Bhojpuri'. His timeless folk plays like 'Bidesiya' (बिदेसिया) and 'Beti Bechaa' addressed migration, separation, and social reforms with unforgettable folk songs.",
            "भिखारी ठाकुर भोजपुरी भाषा र लोकनाट्यका युगपुरुष हुन्। उहाँको 'बिदेसिया' नाटकले परदेशिएका नेपाली-भोजपुरी युवाहरूको विरह र यथार्थलाई अमर बनाएको छ।"
        ),
        Triple(
            "नेपाल तराई अउर पूर्वांचल",
            "Bhojpuri is spoken by tens of millions across Nepal's Terai (Parsa, Bara, Rautahat, Sarlahi) and India's western Bihar and eastern Uttar Pradesh. It bridges borders with warmth, hospitality, and rich musical heritage.",
            "भोजपुरी भाषा नेपालको तराई-मधेश (पर्सा, बारा, रौतहट आदि) तथा भारतको बिहार र उत्तर प्रदेशमा करोडौँ मानिसद्वारा बोलिने समृद्ध एवं मिठासपूर्ण भाषा हो।"
        )
    )

    val cultureHistoryArticles = listOf(
        CultureHistoryArticle(
            id = "art_chhath",
            titleBhojpuri = "छठ महापर्व अउर लोक परंपरा",
            titleNepali = "छठ महापर्व र लोक परम्परा",
            titleEnglish = "Chhath Puja: Sun Worship & Nature Harmony",
            subtitleBhojpuri = "पवित्रता, प्रकृति पूजा अउर सामाजिक समरसता के महापर्व",
            subtitleNepali = "पवित्रता, प्रकृति पूजा र समताको महान् पर्व",
            subtitleEnglish = "The 4-day festival of gratitude to the Sun God & Chhathi Maiya",
            contentBhojpuri = "छठ पूजा भोजपुरी माटी के सबसे पावन पर्व हवे। चार दिन के एह बरत में नहाय-खाय, खरना, संझिया अरघ अउर भिनसरिया अरघ दिहल जाला। नदी-पोखरा के तीरे बिना कवनो जात-पात के भेदभाव के सब लोग एक्के संगे हाथ में बाँस के सूप ले के सूर्य देव के प्रणाम करेला। एह में बनल 'ठेकुआ' अउर मौसमी फल-कंद मूल प्रकृति के प्रति आदर के प्रतीक हवे।",
            contentNepali = "छठ पूजा नेपालको तराई-मधेश र भोजपुरी क्षेत्रको सबैभन्दा ठूलो र निष्ठावान् पर्व हो। चार दिनसम्म चल्ने यस व्रतमा नहाय-खाय, खरना, अस्ताउँदो सूर्यलाई सन्ध्या अर्घ्य र उदाउँदो सूर्यलाई प्रातःकालीन अर्घ्य अर्पण गरिन्छ। नदी र पोखरीको किनारमा धनी-गरिब, जात-पातको कुनै भेदभावबिना सबै श्रद्धालुले बाँसको सूपमा ठेकुवा, फलफूल र कन्दमूल राखी प्रकृति र जीवनदाता सूर्यको पूजा गर्दछन्।",
            contentEnglish = "Chhath Puja is an ancient Vedic festival originating in Mithila, Magadh, and Bhojpur regions. Celebrated over four sacred days—Nahay-Khay (purification), Kharna (sweet kheer offering), Sandhya Arghya (sunset offering in flowing rivers), and Usha Arghya (sunrise gratitude)—it requires no priests or intermediate rituals; devotees directly connect with nature and the visible deity, the Sun God. The offerings include traditional Thekua, ginger plants, sugarcane stalks, and harvest crops.",
            iconEmoji = "🪔",
            drawableResName = "ic_culture_chhath",
            categoryTag = "TRADITION"
        ),
        CultureHistoryArticle(
            id = "art_history",
            titleBhojpuri = "भोजपुरी भाषा के इतिहास अउर कैथी लिपि",
            titleNepali = "भोजपुरी भाषाको इतिहास र कैथी लिपि",
            titleEnglish = "Bhojpuri Linguistic History & The Ancient Kaithi Script",
            subtitleBhojpuri = "मागधी प्राकृत से निकलल सातवीं सदी से आज तक के यात्रा",
            subtitleNepali = "मागधी प्राकृतबाट उत्पत्ति र ऐतिहासिक कैथी लिपिको वैभव",
            subtitleEnglish = "Origins from Magadhi Prakrit and centuries of handwritten manuscripts",
            contentBhojpuri = "भोजपुरी भाषा भारोपीय भाषा परिवार के हिंद-आर्य शाखा से हवे। एकर सीधा संबंध मागधी अपभ्रंश से बा। सातवीं सदी के सिद्ध साहित्य अउर गोरखनाथी परंपरा में भोजपुरी के सुरुआती रूप लउकेला। प्राचीन काल में भोजपुरी भाषा 'कैथी' (Kaithi) लिपि में लिखल जात रहे। कैथी लिपि के प्रयोग नेपाल तराई अउर अवध-बिहार में कचहरी, जमींदारी कागजात अउर व्यापारिक हिसाब-किताब में खूब भइल। बाद में बीसवीं सदी में देवनागरी लिपि के अपनावल गइल।",
            contentNepali = "भोजपुरी भाषा भारोपेली भाषा परिवारको इन्डो-आर्यन शाखाअन्तर्गत पर्ने समृद्ध भाषा हो। यसको विकास मागधी अपभ्रंशबाट भएको मानिन्छ। नेपालको तराई भेग र भारतको पूर्वाञ्चलमा ७औँ शताब्दीदेखि नै लोकगीत, दोहा र चरितका रूपमा यसको निरन्तरता देखिन्छ। ऐतिहासिक रूपमा भोजपुरी भाषा 'कैथी' लिपिमा लेखिन्थ्यो, जसको प्रयोग नेपालको मधेश तथा भारतमा प्रशासनिक अभिलेख, लालमोहर र दस्तावेजमा गरिन्थ्यो। आधुनिक कालमा यो देवनागरी लिपिमा लेखिन्छ।",
            contentEnglish = "Bhojpuri is an Eastern Indo-Aryan language tracing its genealogy directly to Magadhi Prakrit and early Apabhramsha dialects of the 7th century CE. For centuries, the historical cursive script called 'Kaithi' (derived from the scribe caste Kayastha) served as the official literary and legal script throughout the Nepal Terai, western Bihar, and eastern UP. Land deeds, treaties, and royal sanads were inscribed in Kaithi before Devanagari became the standardized modern script in the 20th century. Today, over 50 million people speak Bhojpuri globally, including prominent diaspora populations in Mauritius, Fiji, Trinidad, and Suriname.",
            iconEmoji = "📜",
            drawableResName = "ic_culture_history",
            categoryTag = "HISTORY"
        ),
        CultureHistoryArticle(
            id = "art_theatre",
            titleBhojpuri = "भिखारी ठाकुर अउर बिदेसिया लोकनाट्य",
            titleNepali = "भिखारी ठाकुर र बिदेसिया लोकनाट्य",
            titleEnglish = "Bhikhari Thakur & The Legendary Bidesiya Theatre",
            subtitleBhojpuri = "भोजपुरी के शेक्सपियर अउर लोक गीति-नाट्य परंपरा",
            subtitleNepali = "भोजपुरीका शेक्सपियर र जनजीवन झल्काउने नाट्य विधा",
            subtitleEnglish = "Folk operas capturing migration, social justice & soulful melodies",
            contentBhojpuri = "भिखारी ठाकुर (१८८७–१९७१) के भोजपुरी साहित्य अउर रंगमंच के पितामह मानल जाला। उनकर नाटक 'बिदेसिया' (Bidesiya), 'बेटी बेचवा', 'गबरघिचोर' गाँव के मजदूरन के परदेस जाए, नारी के विरह अउर सामाजिक कुरीति पर करारी चोट कइलस। ढोलक, सारंगी, झाल अउर हरमोनियम के धुन पर खेलल जाए वाला बिदेसिया नाच आजो नेपाल अउर पूर्वांचल के लोक चेतना में अमर बा।",
            contentNepali = "भिखारी ठाकुर (१८८७–१९७१) भोजपुरी साहित्य र नाट्य जगतका अमर सर्जक हुन्, जसलाई 'भोजपुरीका शेक्सपियर' पनि भनिन्छ। उहाँको प्रसिद्ध गीति-नाटक 'बिदेसिया' ले कामका लागि सहर वा परदेश गएका श्रीमान् र घरमा प्रतीक्षा गरिरहेकी श्रीमतीको विरह-व्यथालाई मार्मिक ढङ्गले प्रस्तुत गर्दछ। ढोलक, झाँझ र हार्मोनिमयको तालमा प्रस्तुत गरिने यो लोकनाटकले सामाजिक कुरीति र लैङ्गिक समानताका विषयमा ऐतिहासिक जागरण ल्याएको थियो।",
            contentEnglish = "Bhikhari Thakur (1887–1971), hailed by scholars as the 'Shakespeare of Bhojpuri', was an actor, poet, playwright, and social reformer. His masterpiece folk opera 'Bidesiya' poignantly depicted the pain of rural wives whose husbands migrated far away to Calcutta and Rangoon for labor. Performed beneath open skies with dholak and brass cymbals, his plays tackled bonded labor, dowry, and class oppression through catchy folk melodies like Biraha, Kajari, and Sohar.",
            iconEmoji = "🎭",
            drawableResName = "ic_culture_theatre",
            categoryTag = "THEATRE"
        ),
        CultureHistoryArticle(
            id = "art_terai",
            titleBhojpuri = "नेपाल तराई अउर मिथिला-भोजपुरी संगम",
            titleNepali = "नेपालको तराई-मधेश र भोजपुरी पहिचान",
            titleEnglish = "Bhojpuri in Nepal's Terai: Heritage & Harmony",
            subtitleBhojpuri = "पर्सा, बारा, रौतहट, सर्लाही अउर मोरंग के सांस्कृतिक धरोहर",
            subtitleNepali = "पर्सा, बारा, रौतहट, सर्लाही र मोरङको सांस्कृतिक वैभव",
            subtitleEnglish = "Historical roots and linguistic vitality across the plains of Nepal",
            contentBhojpuri = "नेपाल के मधेश अउर तराई क्षेत्र में भोजपुरी दोसरका सबसे बड़ लोकभाषा हवे। वीरगंज, कलैया, गौर, मलंगवा से ले के नवलपरासी तक भोजपुरी जन-जीवन, खेती-किसानी, व्यापार अउर संस्कृति के प्राण हवे। नेपाल के संविधान में भोजपुरी के राष्ट्रभाषा के मान्यता बा। इहाँ के 'गुड़-पानी' से अतिथि स्वागत करे के परंपरा अउर आपसी भाइचारा भोजपुरी सभ्यता के विशेषता हवे।",
            contentNepali = "नेपालको तराई-मधेशमा भोजपुरी भाषा दोस्रो ठूलो मातृभाषाका रूपमा बोलिन्छ। विशेष गरी पर्सा (वीरगञ्ज), बारा (कलैया), रौतहट (गौर), सर्लाही र नवलपरासीमा भोजपुरी जनजीवनको अभिन्न अङ्ग हो। नेपालको संविधानअनुसार भोजपुरी नेपालको एक प्रमुख राष्ट्रभाषा हो। पाहुनालाई सत्कार गर्दा गुड र पानी (गुड़-पानी) टक्र्याउने, छठ तथा जितिया पर्व भव्य रूपमा मनाउने र किसानको श्रमलाई सम्मान गर्ने परम्परा यसको अनुपम उदाहरण हो।",
            contentEnglish = "In Nepal, Bhojpuri holds an esteemed status as one of the major national languages, predominantly spoken throughout Parsa (Birgunj), Bara (Kalaiya), Rautahat (Gaur), Sarlahi, and Nawalparasi districts. The language bridges the rich agrarian plains with vibrant trade and literature. Cultural customs such as welcoming guests with Gur-Paani (organic jaggery and fresh well water) and celebrating festivals like Jitiya, Chhath, and Sama Chakeva represent deep-rooted ecological and family ethics.",
            iconEmoji = "🇳🇵",
            drawableResName = null,
            categoryTag = "HERITAGE"
        ),
        CultureHistoryArticle(
            id = "art_cuisine",
            titleBhojpuri = "पारंपरिक खान-पान: लिट्टी चोखा, सत्तू अउर स्वाद",
            titleNepali = "परम्परागत खानपान: लिट्टी चोखा, सातु र स्वाद",
            titleEnglish = "Culinary Heritage: Litti Chokha & Sattu Traditions",
            subtitleBhojpuri = "देसी माटी के सोंध महक अउर सेहतमंद खान-पान",
            subtitleNepali = "माटोको सुगन्ध, स्वास्थ्यवर्धक परिकार र परम्परा",
            subtitleEnglish = "Nutritious roasted gram sattu, wood-fire baked litti, and mustard flavours",
            contentBhojpuri = "भोजपुरी खान-पान सीधा, सात्विक अउर सेहतमंद होला। गोइठा (उपला) के धीमा आँच पर सेकल लिट्टी अउर ओकरा में भरल अजवाइन-मंगरेल वाला सत्तू विश्वभर में प्रसिद्ध बा। संगे बैंगन, टमाटर अउर हरी मिर्च के भुंजल चोखा, देसी घी, भात-दाल-भुजिया, अउर मीठ में अनरसा आ ठेकुआ भोजपुरी माटी के पहचान हवे।",
            contentNepali = "भोजपुरी खानपान अत्यन्तै पोषिलो, प्राङ्गारिक र स्वादिलो मानिन्छ। भुटेको चनाको सातुमा ज्वानो, मङ्ग्रेल, तोरीको तेल र कागती मिसाएर गहुँको डल्लोमा भरी गोबरको गुइँठामा बिस्तारै पोलेर बनाइने 'लिट्टी' र पोलेको भ्यान्टा-गोलभेँडाको 'चोखा' यसको विशिष्ट परिकार हो। यसका साथै अनरसा, ठेकुवा र मालपुवा चाडपर्वमा विशेष रूपमा पकाइन्छ।",
            contentEnglish = "Bhojpuri gastronomy is celebrated for its earthy ingredients and gut-friendly nutrition. The crowning glory is 'Litti Chokha'—whole-wheat dough balls stuffed with spiced roasted Bengal gram flour (sattu) flavored with ajwain, kalonji, mustard oil, and pickles, traditionally baked slowly over dried cow-dung patties. It is crushed, soaked in pure ghee, and paired with 'Chokha' (smoked eggplant, roasted tomatoes, garlic, and green chilies). Other traditional treats include crispy Thekua, sweet Anarsa, and cool savory sattu drinks in summer.",
            iconEmoji = "🍲",
            drawableResName = null,
            categoryTag = "CUISINE"
        )
    )
}

