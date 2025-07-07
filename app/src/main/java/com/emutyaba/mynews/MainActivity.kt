package com.emutyaba.mynews

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var newsAdapter: NewsAdapter
    private lateinit var newsList: List<NewsItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.flFragment, HomeFragment())
            .commit()

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNav.setOnItemSelectedListener { item ->
            val selectedFragment = when (item.itemId) {
                R.id.nav_home -> HomeFragment()
                R.id.nav_sports -> SportsFragment()
                R.id.nav_scietech -> ScienceandtechFragment()

                else -> HomeFragment()
            }
            //
            supportFragmentManager.beginTransaction()
                .replace(R.id.flFragment, selectedFragment)
                .commit()
            true
        }

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Sample data
        newsList = listOf(
            NewsItem("Trump on a high after tremendous wins at home and abroad", "Donald Trump's week began with an on-air expletive as he lost his cool over his mounting frustrations with Iran and Israel's shaky ceasefire", R.drawable.trmp),
            NewsItem("Jayne knew exactly what she was doing!", " The forgotten story behind the most famous side-eye in Hollywood history", R.drawable.soph),
            NewsItem("Iran holds state funeral for military leaders killed in Israel conflict", "A state funeral has been held in Iran for about 60 people, including military commanders and nuclear scientists, killed during the 12-day conflict with Israel.", R.drawable.isr),
            NewsItem("What’s new in Museveni’s 2026 agenda?", "The long-serving leader picked nomination forms from the NRM Electoral Commission headquarters in Kampala, formally declaring his intent to run both as NRM party chairperson and presidential flag bearer", R.drawable.musv),
            NewsItem("Ugandan opposition figure taken to military court after Kenya expulsion", "Prominent Ugandan opposition figure Kizza Besigye has appeared before a military court in the capital, Kampala, where he has denied charges that include the illegal possession of firearms and negotiating to buy arms abroad.", R.drawable.bes),
            NewsItem("DR Congo and Rwanda sign long-awaited peace deal in Washington", "Rwanda and the Democratic Republic of Congo have signed a peace deal in Washington aimed at ending decades of devastating conflict between the two neighbours, and potentially granting the US lucrative mineral access.", R.drawable.drc),
            NewsItem("'I tell my children not to play so we save money on soap'", "Suzanna Kathumba, a domestic worker in Malawi, spends every day thinking of ways she can economise to make her salary of 80,000 kwacha (\$46; £34) a month stretch to support her family.", R.drawable.sav),
            NewsItem("Mandhana stars as India inflict record loss on England", "Scorecard\n" +
                    "\n" +
                    "Smriti Mandhana scored a stunning century as India inflicted England's heaviest T20 defeat by runs with a comprehensive 97-run triumph at Trent Bridge.\n" +
                    "\n" +
                    "The opener blitzed 112 from 62 balls for her maiden T20 international hundred as India posted 210-5 on a flat surface in the series opener.", R.drawable.spot),
            NewsItem("How sleeping in old schools is reviving rural Japan", "As Japan's dwindling population increasingly migrates to cities, 450 rural schools close each year. Now, some are being transformed into unique inns.", R.drawable.jap)
        )

        newsAdapter = NewsAdapter(newsList)
        recyclerView.adapter = newsAdapter
    }


            // Load default fragment




}

