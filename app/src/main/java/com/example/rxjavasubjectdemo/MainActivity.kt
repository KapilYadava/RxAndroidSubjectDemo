package com.example.rxjavasubjectdemo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.subjects.AsyncSubject
import io.reactivex.rxjava3.subjects.BehaviorSubject
import io.reactivex.rxjava3.subjects.PublishSubject
import io.reactivex.rxjava3.subjects.ReplaySubject

class MainActivity : AppCompatActivity() {

    private val TAG = "RxJavaSubject"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //asyncSubjectDemo1()
        //asyncSubjectDemo2()
        //behaviourSubjectDemo1()
        //behaviourSubjectDemo2()
        //publishSubjectDemo1()
        //publishSubjectDemo2()
        //replaySubjectDemo1()
        replaySubjectDemo2()
    }

    private fun asyncSubjectDemo1(){
        val observable = Observable.just("Java", "Kotlin", "XML", "JSON")
        val subject = AsyncSubject.create<String>()
        observable.subscribe(subject)

        subject.subscribe(getObserver1())
        subject.subscribe(getObserver2())
        subject.subscribe(getObserver3())
    }

    private fun asyncSubjectDemo2(){
        val subject = AsyncSubject.create<String>()

        subject.subscribe(getObserver1())

        subject.onNext("Java")
        subject.onNext("Kotlin")
        subject.onNext("XML")

        subject.subscribe(getObserver2())

        subject.onNext("JSON")
        subject.onComplete()

        subject.subscribe(getObserver3())

    }

    private fun behaviourSubjectDemo1(){
        val observable = Observable.just("Java", "Kotlin", "XML", "JSON")
        val subject = BehaviorSubject.create<String>()

        observable.subscribe(subject)

        subject.subscribe(getObserver1())
        subject.subscribe(getObserver2())
        subject.subscribe(getObserver3())
    }


    private fun behaviourSubjectDemo2(){
        val subject = BehaviorSubject.create<String>()

        subject.subscribe(getObserver1())

        subject.onNext("Java")
        subject.onNext("Kotlin")
        subject.onNext("XML")

        subject.subscribe(getObserver2())

        subject.onNext("JSON")
        subject.onComplete()

        subject.subscribe(getObserver3())

    }

    private fun publishSubjectDemo1(){
        val observable = Observable.just("Java", "Kotlin", "XML", "JSON")
        val subject = PublishSubject.create<String>()

        observable.subscribe(subject)

        subject.subscribe(getObserver1())
        subject.subscribe(getObserver2())
        subject.subscribe(getObserver3())
    }


    private fun publishSubjectDemo2(){
        val subject = PublishSubject.create<String>()

        subject.subscribe(getObserver1())

        subject.onNext("Java")
        subject.onNext("Kotlin")
        subject.onNext("XML")

        subject.subscribe(getObserver2())

        subject.onNext("JSON")
        subject.onComplete()

        subject.subscribe(getObserver3())

    }

    private fun replaySubjectDemo1(){
        val observable = Observable.just("Java", "Kotlin", "XML", "JSON")
        val subject = ReplaySubject.create<String>()

        observable.subscribe(subject)

        subject.subscribe(getObserver1())
        subject.subscribe(getObserver2())
        subject.subscribe(getObserver3())
    }


    private fun replaySubjectDemo2(){
        val subject = ReplaySubject.create<String>()

        subject.subscribe(getObserver1())

        subject.onNext("Java")
        subject.onNext("Kotlin")
        subject.onNext("XML")

        subject.subscribe(getObserver2())

        subject.onNext("JSON")
        subject.onComplete()

        subject.subscribe(getObserver3())

    }


    private fun getObserver1(): Observer<String>{
        return object : Observer<String>{
            override fun onSubscribe(d: Disposable?) {
                Log.v(TAG, "First Observer onSubscribe: $d")
            }

            override fun onNext(t: String?) {
                Log.v(TAG, "First Observer onNext: $t")
            }

            override fun onError(e: Throwable?) {
                Log.v(TAG, "First Observer onError: $e")
            }

            override fun onComplete() {
                Log.v(TAG, "First Observer onComplete")
            }
        }
    }

    private fun getObserver2(): Observer<String>{
        return object : Observer<String>{
            override fun onSubscribe(d: Disposable?) {
                Log.v(TAG, "Second Observer onSubscribe: $d")
            }

            override fun onNext(t: String?) {
                Log.v(TAG, "Second Observer onNext: $t")
            }

            override fun onError(e: Throwable?) {
                Log.v(TAG, "Second Observer onError: $e")
            }

            override fun onComplete() {
                Log.v(TAG, "Second Observer onComplete")
            }
        }
    }

    private fun getObserver3(): Observer<String>{
        return object : Observer<String>{
            override fun onSubscribe(d: Disposable?) {
                Log.v(TAG, "Third Observer onSubscribe: $d")
            }

            override fun onNext(t: String?) {
                Log.v(TAG, "Third Observer onNext: $t")
            }

            override fun onError(e: Throwable?) {
                Log.v(TAG, "Third Observer onError: $e")
            }

            override fun onComplete() {
                Log.v(TAG, "Third Observer onComplete")
            }
        }
    }
}
