package ru.kheynov.feature_stories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StoriesScreenViewModel : ViewModel() {
    private val _items = listOf(
        Story(
            image = "https://starsity.ru/wp-content/uploads/2020/04/10051553.jpg",
            city = "Новосибирск",
            date = "12.07.2019",
            header = "Оперный театр",
            description = "Один из ведущих театров России",
            link = "https://ru.wikipedia.org/wiki/Новосибирский_театр_оперы_и_балета"
        ),
        Story(
            image = "https://stroi.mos.ru/uploads/cache/gallery_media_full/gallery_media/0001/31/566737de5313376ab3ded3f7152b5e0b14d169b1.jpeg",
            city = "Москва",
            date = "22.09.2014",
            header = "ВДНХ",
            description = "Первый по величине территории выставочный комплекс в Москве",
            link = "https://ru.wikipedia.org/wiki/Выставка_достижений_народного_хозяйства"
        ),
        Story(
            image = "https://ug.ru/wp-content/uploads/2021/06/pamjatnik_bukve__3.jpg",
            city = "Ульяновск",
            date = "14.05.2018",
            header = "Памятник букве \"ё\"",
            description = "Установлен в честь 205-ти летия применения буквы",
            link = "https://ru.wikipedia.org/wiki/Памятник_букве_«ё»"
        ),
        Story(
            image = "https://static.tonkosti.ru/tonkosti/table_img/g142/9a9a/57246420.jpg",
            city = "Санкт-Петербург",
            date = "12.07.2017",
            header = "Петергоф",
            description = "от нем. Peterhof — «двор Петра»",
            link = "https://ru.wikipedia.org/wiki/Петергоф"
        ),
        Story(
            image = "https://a.d-cd.net/KIAAAgKSP2A-1920.jpg",
            city = "Владивосток",
            date = "01.03.2000",
            header = "Золотой мост",
            description = "Был построен в рамках программы подготовки города к проведению саммита АТЭС",
            link = "https://ru.wikipedia.org/wiki/Золотой_мост"
        ),
    )
    val items: List<Story>
        get() = _items

    private val _storiesProgress: MutableLiveData<Int> = MutableLiveData(0)
    val storiesProgress: LiveData<Int>
        get() = _storiesProgress


    fun incrementProgress() {
        if (_storiesProgress.value!! < items.size - 1) _storiesProgress.value =
            _storiesProgress.value?.inc()
        else _storiesProgress.value = 0
    }

    fun decrementProgress() {
        if (_storiesProgress.value!! > 0) _storiesProgress.value = _storiesProgress.value?.dec()
        else _storiesProgress.value = items.size - 1
    }

}