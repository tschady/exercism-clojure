(ns phone-number
  (:require [clojure.string :as str]))

(def invalid-code "0000000000")

(defn number
  "Return a 10 digit string representing a phone number, by removing
  any punctuation and optional country code.
  If a number is invalid, return a string of 10 zeros."
  [s]
  (let [digitized (str/replace s #"\D" "")
        sans-country (if (and (= 11 (count digitized))
                              (= (first digitized) \1))
                       (subs digitized 1)
                       digitized)]
    (if (= 10 (count sans-country))
      sans-country
      invalid-code)))

(defn- parsed-number
  "Break input number into hash of :areacode, :exchange, and :subscriber"
  [s]
  (let [digits (number s)
        areacode (subs digits 0 3)
        exchange (subs digits 3 6)
        subscriber (subs digits 6 10)]
    {:areacode areacode :exchange exchange :subscriber subscriber}))

(defn area-code
  "Return area-code portion of input phone number, as a string of 3 digits"
  [s]
  (:areacode (parsed-number s)))

(defn pretty-print
  "Return phone number normalized to '(xxx) xxx-xxxx'"
  [s]
  (let [number (parsed-number s)]
    (format "(%s) %s-%s"
            (:areacode number) (:exchange number) (:subscriber number))))

