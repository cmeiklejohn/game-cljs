;; Copyright (c) Christopher Meiklejohn. All rights reserved.
;;
;; The use and distribution terms for this software are covered by the
;; Eclipse Public License 1.0 which can be found in the file
;; LICENSE.html at the root of this distribution.  By using this
;; software in any fashion, you are agreeing to be bound by the terms of
;; this license. You must not remove this notice, or any other, from
;; this software.
;;
(ns game.core
  (:require [strokes :refer [d3]]))

(strokes/bootstrap)

;; Setup the initial state.

(def body (-> d3 (.select "#container")))

(def board (-> body (.append "div") (.attr "class" "board")))

;; Chart updater.

(defn update [data]
  (let [sections (-> board (.selectAll "ul") (.data data #(:id %)))]
    (-> sections (.enter) (.append "ul")
      (.attr {:class "section"}))
    (let [cards (-> sections (.selectAll "li") (.data #(:cards %) #(:id %)))]
      (-> cards (.enter) (.append "li")
        (.html #(:name %)))
      (-> cards (.exit) (.remove)))))

;; Initialize the default state.

(def initial-state
  [{:id 1 :cards [{:id 1 :name "Omar Little" :owner ""}]}
   {:id 2 :cards [{:id 2 :name "Calvin 'Cheese' Wagstaff" :owner "images/bunk.jpg"}
                  {:id 3 :name "Russell 'Stringer' Bell" :owner "images/mcnulty.jpg"}
                  {:id 4 :name "Savino Bratton" :owner "images/kima.jpg"}]}
   {:id 3 :cards [{:id 2 :name "Calvin 'Cheese' Wagstaff" :owner "images/bunk.jpg"}
                  {:id 3 :name "Russell 'Stringer' Bell" :owner "images/mcnulty.jpg"}
                  {:id 4 :name "Savino Bratton" :owner "images/kima.jpg"}]}
   {:id 4 :cards [{:id 5 :name "Marlo Stanfield" :owner "images/bunk.jpg"}]}])

;; Trigger initial loading.

(update initial-state)
