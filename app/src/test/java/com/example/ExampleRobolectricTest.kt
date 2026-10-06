package com.example

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.example.data.BhojpuriDataSource
import com.example.model.AppLanguage
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [36])
class ExampleRobolectricTest {

  @Test
  fun `read string from context`() {
    val context = ApplicationProvider.getApplicationContext<Context>()
    val appName = context.getString(R.string.app_name)
    assertEquals("Bhojpuri Bhasa", appName)
  }

  @Test
  fun `verify bhojpuri dataset loaded with trilingual support`() {
    assertTrue(BhojpuriDataSource.vocabularies.isNotEmpty())
    assertTrue(BhojpuriDataSource.lessons.isNotEmpty())
    assertTrue(BhojpuriDataSource.quizzes.isNotEmpty())
    assertTrue(BhojpuriDataSource.proverbs.isNotEmpty())

    val firstWord = BhojpuriDataSource.vocabularies.first()
    assertEquals("प्रणाम", firstWord.bhojpuri)
    assertTrue(firstWord.getMeaning(AppLanguage.ENGLISH).isNotEmpty())
    assertTrue(firstWord.getMeaning(AppLanguage.NEPALI).isNotEmpty())
    assertTrue(firstWord.getMeaning(AppLanguage.BHOJPURI).isNotEmpty())
  }

  @Test
  fun `verify culture and history articles exist`() {
    assertTrue(BhojpuriDataSource.cultureHistoryArticles.isNotEmpty())
    val chhathArticle = BhojpuriDataSource.cultureHistoryArticles.first { it.id == "art_chhath" }
    assertTrue(chhathArticle.getContent(AppLanguage.ENGLISH).isNotEmpty())
    assertTrue(chhathArticle.getContent(AppLanguage.NEPALI).isNotEmpty())
    assertTrue(chhathArticle.getContent(AppLanguage.BHOJPURI).isNotEmpty())
  }
}
