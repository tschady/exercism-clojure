(ns kindergarten-garden
  (:require [clojure.string :as str]))

(def default-students ["Alice" "Bob" "Charlie" "David" "Eve" "Fred" "Ginny"
                       "Harriet" "Ileana" "Joseph" "Kincaid" "Larry"])

(def char->plants {\C :clover
                   \G :grass
                   \R :radishes
                   \V :violets})

(defn- keywordize-students
  "Transform collection of student name strings into sorted keywords"
  [names]
  (->> names
       (map str/lower-case)
       (map keyword)
       (sort)))

(defn garden
  "Given garden string `s`, return map of students to their plantings.
  Both students and plants are represented by keywords."
  ([s] (garden s default-students))
  ([s students]
   (let [student-keys (keywordize-students students)]
     (->> s
          str/split-lines
          (map seq)
          (map #(map char->plants %))
          (map #(partition 2 %))
          (apply interleave)
          flatten
          (partition 4)
          (zipmap student-keys)))))
