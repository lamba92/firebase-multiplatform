rmdir /q /s build
rmdir /q /s .idea
rmdir /q /s .gradle
del /q /s *.iml

rmdir /q /s buildSrc\build
rmdir /q /s buildSrc\.idea
rmdir /q /s buildSrc\.gradle
del /q /s buildSrc\*.iml

rmdir /q /s core\build
rmdir /q /s core\.idea
rmdir /q /s core\.gradle
del /q /s core\*.iml

rmdir /q /s auth\build
rmdir /q /s auth\.idea
rmdir /q /s auth\.gradle
del /q /s auth\*.iml
