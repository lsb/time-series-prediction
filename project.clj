(defproject time-series-prediction "0.1.0-SNAPSHOT"
  :description "Time series prediction for login information"
  :url nil
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.3.1"]
                 [org.flatland/protobuf "0.8.1"]
                 [ring/ring-defaults "0.1.2"]]
  :plugins [[lein-protobuf "0.4.1"]
            [lein-ring "0.8.13" :exclusions [org.clojure/clojure]]]
  :ring {:handler time-series-prediction.handler/app :init time-series-prediction.handler/async}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring-mock "0.1.5"]]}})
