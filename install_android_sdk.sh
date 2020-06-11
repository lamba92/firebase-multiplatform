mkdir -p ~/.android && touch ~/.android/repositories.cfg
echo " - sdkmanager --update"
sdkmanager --update > /dev/null 2>&1
echo " - sdkmanager --licenses"
yes | sdkmanager --licenses > /dev/null 2>&1
echo " - sdkmanager \"platform-tools\" \"platforms;android-29\" \"build-tools;30.0.0\""
sdkmanager "platform-tools" "platforms;android-29" "build-tools;30.0.0" > /dev/null 2>&1
yes | sdkmanager --licenses > /dev/null 2>&1
