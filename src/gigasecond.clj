(ns gigasecond
  (:require [clj-time.core :as t]))

(defn from
  "Return date tuple ([YYYY m d]) representing one gigasecond (10^9 seconds)
  later than input date given by `y`, `m`, `d`."
  [y m d]
  (let [input-date (t/date-time y m d)
        output-date (t/plus input-date (t/seconds 1000000000))]
    [(t/year output-date) (t/month output-date) (t/day output-date)]))
