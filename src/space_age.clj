(ns space-age)

(def earth->planet {:mercury 0.2408467
                    :venus 0.61519726
                    :mars 1.8808158
                    :jupiter 11.862615
                    :saturn 29.447498
                    :uranus 84.016846
                    :neptune 164.79132})

(defn on-earth
  "For a given number of seconds, return equivalent earth-years"
  [n]
  (/ n 31557600.))

(defn on-mercury [n] (/ (on-earth n) (:mercury earth->planet)))
(defn on-venus [n] (/ (on-earth n) (:venus earth->planet)))
(defn on-mars [n] (/ (on-earth n) (:mars earth->planet)))
(defn on-saturn [n] (/ (on-earth n) (:saturn earth->planet)))
(defn on-jupiter [n] (/ (on-earth n) (:jupiter earth->planet)))
(defn on-neptune [n] (/ (on-earth n) (:neptune earth->planet)))
(defn on-uranus [n] (/ (on-earth n) (:uranus earth->planet)))
