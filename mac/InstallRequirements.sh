brew tap adoptopenjdk/openjdk
brew install --cask adoptopenjdk16
/usr/libexec/java_home -v16
open ~/.bash_profile
export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk-16.0.2.jdk/Contents/Home
source ~/.bash_profile