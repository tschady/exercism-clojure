(ns luhn-test
  (:require [clojure.test :refer [deftest is testing]]
            luhn
            [clojure.spec.alpha :as s]))

(deftest validity-tests
  (testing "single digit strings can not be valid"
    (is (false? (s/valid? :luhn/luhn "1"))))
  (testing "A single zero is invalid"
    (is (false? (s/valid? :luhn/luhn "0"))))
  (testing "simple valid sin"
    (is (true? (s/valid? :luhn/luhn " 5 9 "))))
  (testing "valid Canadian SIN"
    (is (true? (s/valid? :luhn/luhn "046 454 286"))))
  (testing "invalid Canadian SIN"
    (is (false? (s/valid? :luhn/luhn "046 454 287"))))
  (testing "invalid credit card"
    (is (false? (s/valid? :luhn/luhn "8273 1232 7352 0569"))))
  (testing "valid strings with a non-digit added become invalid"
    (is (false? (s/valid? :luhn/luhn "046a 454 286"))))
  (testing "punctuation is not allowed"
    (is (false? (s/valid? :luhn/luhn "055-444-285"))))
  (testing "symbols are not allowed"
    (is (false? (s/valid? :luhn/luhn "055£ 444$ 285"))))
  (testing "single zero with space is invalid"
    (is (false? (s/valid? :luhn/luhn " 0"))))
  (testing "lots of zeros are valid"
    (is (true? (s/valid? :luhn/luhn " 00000"))))
  (testing "another valid sin"
    (is (true? (s/valid? :luhn/luhn "055 444 285"))))
  (testing "nine doubled is nine"
    (is (true? (s/valid? :luhn/luhn "091"))))
)
