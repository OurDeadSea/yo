(defproject yo "0.0.1"
  :description "Chat bot experiment"
  :url "https://github.com/OurDeadSea/yo"
  :license {:name "GNU General Public License v3.0"
            :url  "https://www.gnu.org/licenses/gpl-3.0.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/data.json "0.2.6"]
                 [org.clojure/tools.logging "0.4.0"]
                 [org.clojure/core.async "0.3.443"]
                 [org.clojure/core.logic "0.8.11"]
                 [clj-http "3.6.1"]
                 [stylefruits/gniazdo "1.0.1"]]
  :main ^:skip-aot yo.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
