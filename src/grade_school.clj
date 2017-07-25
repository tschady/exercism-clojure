(ns grade-school)

(defn grade [db grade_num]
  (get db grade_num []))

(defn add [db student grade_num]
  (assoc db grade_num (conj (grade db grade_num) student)))

(defn sorted [db]
  (letfn [(sort-students [m k v] (assoc m k (sort v)))]
    (reduce-kv sort-students (sorted-map) db)))
