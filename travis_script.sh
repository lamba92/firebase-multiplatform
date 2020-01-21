sudo ./gradlew extractFirebaseIosZip --console=plain -PskipBuild=true
sudo chmod -R a+rwx .
sudo chown -R travis .
./gradlew build --console=plain --parallel