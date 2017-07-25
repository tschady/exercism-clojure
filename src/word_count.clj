(ns word-count
  (:require [clojure.string :refer [lower-case split]]))

(def word-count (comp frequencies #(split % #"\W+") lower-case))
