package de.sample.android.ksfapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

//The way to refer to the context object
//--this: lambda receiver -> run, with, and apply
//--it : lambda argument -> let , also
//The return value.
//--returns the context object -> apply & also
//--returns the lambda result -> let, run, and with

class MainActivity : AppCompatActivity() {
    val theWeb = arrayOf(
        WebSite(
            true,
            "www.example1.com",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ",
            "24.07.1994"
        ),
        WebSite(
            true,
            "www.example2.com",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ",
            "06.07.1994"
        ),
        WebSite(
            true,
            "www.example3.com",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ",
            "05.07.1994"
        ),
        WebSite(
            false,
            "www.example4.com",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ",
            "18.07.1994"
        ),
        WebSite(
            true,
            "www.example5.com",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ",
            "13.07.1994"
        ),
        WebSite(
            false,
            "www.example6.com",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ",
            "15.07.1994"
        ),
        WebSite(
            true,
            "www.example7.com",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ",
            "22.07.1994"
        ),
        WebSite(
            true,
            "www.example8.com",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ",
            "26.07.1994"
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mySearchEngine = SearchEngine()

        //initilaze
        mySearchEngine.run {
            websites = theWeb
        }
        //configure
        mySearchEngine.apply {
            query = Query(50, SortType.ALPHABETICAL, false)
        }.search()//go
            .let {
                it.map { website ->
                    Log.i("Website", website.address)
                }
            }//get

//        repeat(2) {
//            mySearchEngine.takeIf {
//                it.query.sortType != null
//            }?.takeUnless {
//                it.websites.size > 1000
//            }?.logTheFullSize()
//        }

//        mySearchEngine.blowUpIfEmpty()
    }

}