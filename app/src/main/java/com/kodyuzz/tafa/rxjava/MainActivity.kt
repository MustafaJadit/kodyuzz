package com.kodyuzz.tafa.rxjava

import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.kodyuzz.tafa.R
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.*
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.functions.Consumer
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit


class MainActivity : AppCompatActivity() {
    companion object {

        private const val TAG = "MainActivity"
    }


    private fun test() {
        var mainViewModel = MainViewModel()

        mainViewModel.mutableLiveData.observe(this, Observer {
            it.length
            Toast.makeText(applicationContext, it, Toast.LENGTH_SHORT).show()
        })
    }

    private fun test2() {


        var observable = Observable.just("1", "2")

        var observer = object : io.reactivex.rxjava3.core.Observer<String> {
            override fun onComplete() {
                TODO("Not yet implemented")
            }

            override fun onSubscribe(d: Disposable?) {
                TODO("Not yet implemented")
            }

            override fun onNext(t: String?) {
                TODO("Not yet implemented")
            }

            override fun onError(e: Throwable?) {
                TODO("Not yet implemented")
            }
        }

        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer)
    }

    fun test3() {

        var observer = object : io.reactivex.rxjava3.core.Observer<String> {
            override fun onComplete() {
                TODO("Not yet implemented")
            }

            override fun onSubscribe(d: Disposable?) {
                TODO("Not yet implemented")
            }

            override fun onNext(t: String?) {
                TODO("Not yet implemented")
            }

            override fun onError(e: Throwable?) {
                TODO("Not yet implemented")
            }
        }


    }


    fun test4() {
        var observable = Observable.fromArray(1, 4)

        var disposable = observable.subscribe(Consumer {
            println("first line")


        })

        var disposable2 = observable.subscribe(Consumer {
            println("second line")


        })

        var addAll = CompositeDisposable().addAll(disposable, disposable2)
        CompositeDisposable().clear()
//        observable
//                .subscribe(object : io.reactivex.rxjava3.core.Observer<Int> {
//                    override fun onComplete() {
//                    }
//
//                    override fun onSubscribe(d: Disposable?) {
//                    }
//
//                    override fun onNext(t: Int?) {
//                    }
//
//                    override fun onError(e: Throwable?) {
//                    }
//
//                })


    }


    fun test5() {
        fun getSingleObservable(): Single<String> {
            return Single.create { emitter ->
                Log.d(TAG, "getSingleObservable: ")
                if (!emitter.isDisposed) {
                    emitter.onSuccess("yama")
                }
            }
        }

        getSingleObservable().subscribe(object : SingleObserver<String> {
            override fun onSuccess(t: String?) {
                Log.d(TAG, "onSuccess: ")
            }

            override fun onSubscribe(d: Disposable?) {
                Log.d(TAG, "onSubscribe: ")
            }

            override fun onError(e: Throwable?) {
                Log.d(TAG, "onError: ")
            }
        })
    }

    fun test6() {
        fun getMaybeObservable(): Maybe<String> {
            return Maybe.create { emitter ->
                if (!emitter.isDisposed) {
                    emitter.onSuccess("maybe1")
                    emitter.onComplete()
                }
            }
        }

        getMaybeObservable().subscribe(object : MaybeObserver<String> {
            override fun onSuccess(t: String?) {
                Log.d(TAG, "onSuccess: ")
            }

            //being called if no emission
            override fun onComplete() {
                Log.d(TAG, "onComplete: ")
            }

            override fun onSubscribe(d: Disposable?) {
                Log.d(TAG, "onSubscribe: ")
            }

            override fun onError(e: Throwable?) {
                Log.d(TAG, "onError: ")
            }
        })
    }

    fun test7() {
        fun getCompletableObservable(): Completable {
            return Completable.create { emitter ->
                if (!emitter.isDisposed)
                    emitter.onComplete()
            }
        }

        getCompletableObservable().subscribe(object : CompletableObserver {
            override fun onComplete() {
                Log.d(TAG, "onComplete: ")
            }

            override fun onSubscribe(d: Disposable?) {
                Log.d(TAG, "onSubscribe: ")
            }

            override fun onError(e: Throwable?) {
                Log.d(TAG, "onError: ")
            }
        })
    }

    fun test8() {
        fun getFlowable(): Flowable<String> {
            return Flowable.just("a", "b")
        }

        getFlowable().subscribe { Log.d(TAG, "test8: $it") }
    }

    fun test9() {
        var o1: Observable<String> = Observable.just("")
        var editText = EditText(this)
        editText
        o1.debounce(3, TimeUnit.MILLISECONDS).filter { m -> !m.isEmpty() }
                .distinctUntilChanged()
                 .subscribe(object : io.reactivex.rxjava3.core.Observer<String> {
                    override fun onComplete() {
                        TODO("Not yet implemented")
                    }

                    override fun onSubscribe(d: Disposable?) {
                        TODO("Not yet implemented")
                    }

                    override fun onNext(t: String?) {
                        TODO("Not yet implemented")
                    }

                    override fun onError(e: Throwable?) {
                        TODO("Not yet implemented")
                    }
                })
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

//        test()
//        test2()
//        test3()
//        test4()
//        test5()
//        test6()
//        test7()
//        test8()
        test9()
    }


}