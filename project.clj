;; Copyright (c) Christopher Meiklejohn. All rights reserved.
;;
;; The use and distribution terms for this software are covered by the
;; Eclipse Public License 1.0 which can be found in the file
;; LICENSE.html at the root of this distribution.  By using this
;; software in any fashion, you are agreeing to be bound by the terms of
;; this license. You must not remove this notice, or any other, from
;; this software.
;;
(defproject game "0.0.1-SNAPSHOT"
  :description "The Game, authored in ClojureScript"
  :url "https://github.com/cmeiklejohn/game-cljs"
  :license {:name "Eclipse Public License - v 1.0"
            :url "http://www.eclipse.org/legal/epl-v10.html"
            :distribution :repo
            :comments "same as Clojure"}
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.5.0"]
                 [net.drib/strokes "0.4.0"]]
  :plugins [[lein-cljsbuild "0.3.0"]]
  :source-paths ["src/clj" "src/cljs"]
  :hooks [leiningen.cljsbuild]
  :cljsbuild
    {:builds
     [{:source-paths ["src/cljs"],
       :id "core",
       :compiler
       {:pretty-print true,
        :output-to "resources/public/js/core.js",
        :optimizations :simple}}
      ]})
