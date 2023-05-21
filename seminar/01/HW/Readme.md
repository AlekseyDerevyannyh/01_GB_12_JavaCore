# Java Core
## Домашняя работа 1
* **
### Автор:
Деревянных Алексей
* **
Для запуска контейнера используем следующие команды:
````bash
aleksey@ubuntu-gb:/mnt/d/Git/01_GB/01_GB_Developer/12_JavaCore/seminar/01/HW$ docker build . -t hw1:v1
[+] Building 8.5s (9/9) FINISHED
 => [internal] load build definition from dockerfile                                                                                        0.1s
 => => transferring dockerfile: 237B                                                                                                        0.0s
 => [internal] load .dockerignore                                                                                                           0.1s
 => => transferring context: 2B                                                                                                             0.0s
 => [internal] load metadata for docker.io/bellsoft/liberica-openjdk-alpine:11.0.16                                                         1.7s
 => [internal] load build context                                                                                                           0.1s
 => => transferring context: 4.25kB                                                                                                         0.0s
 => [1/4] FROM docker.io/bellsoft/liberica-openjdk-alpine:11.0.16@sha256:79feecb2c3fa88a5ca171a521b5625e9138b5f5764d1db8c33dc343b4eb251bb   4.4s
 => => resolve docker.io/bellsoft/liberica-openjdk-alpine:11.0.16@sha256:79feecb2c3fa88a5ca171a521b5625e9138b5f5764d1db8c33dc343b4eb251bb   0.0s
 => => sha256:5c31d019b56dae62a0e693b47fd3ba63935dfde419ebbb5f7bac0122aa4bbe10 952B / 952B                                                  0.0s
 => => sha256:fa16e95fa5a1a06dd58a19d9671296f63fc000f10c4ed578999221dea2006579 15.80kB / 15.80kB                                            0.0s
 => => sha256:213ec9aee27d8be045c6a92b7eac22c9a64b44558193775a1a7f626352392b49 2.81MB / 2.81MB                                              0.3s
 => => sha256:b2d19556dd2f318604865533cdd442e9522dd01b8a5886d91289e32baae26ef8 3.55MB / 3.55MB                                              0.5s
 => => sha256:1aa6013a00875058ca0dea03e30e8257fb056b12f083a2a481ae18fb7c03183f 79.15MB / 79.15MB                                            2.9s
 => => sha256:79feecb2c3fa88a5ca171a521b5625e9138b5f5764d1db8c33dc343b4eb251bb 741B / 741B                                                  0.0s
 => => extracting sha256:213ec9aee27d8be045c6a92b7eac22c9a64b44558193775a1a7f626352392b49                                                   0.1s
 => => extracting sha256:b2d19556dd2f318604865533cdd442e9522dd01b8a5886d91289e32baae26ef8                                                   0.1s
 => => extracting sha256:1aa6013a00875058ca0dea03e30e8257fb056b12f083a2a481ae18fb7c03183f                                                   1.2s
 => [2/4] COPY ./src ./src                                                                                                                  0.7s
 => [3/4] RUN mkdir ./out                                                                                                                   0.3s
 => [4/4] RUN javac -sourcepath ./src -d out src/ru/gb/hw1/sample/Main.java                                                                 1.1s
 => exporting to image                                                                                                                      0.1s
 => => exporting layers                                                                                                                     0.1s
 => => writing image sha256:21a30dab9e95a5e7e75bd6be98d97ad72c4d8ae7db7060e82b37ad80ac27b968                                                0.0s
 => => naming to docker.io/library/hw1:v1                                                                                                   0.0s
aleksey@ubuntu-gb:/mnt/d/Git/01_GB/01_GB_Developer/12_JavaCore/seminar/01/HW$ docker run --rm hw1:v1
Here is your number: 4.
Here is your number: 4.
Here is your number: 9.
Here is your number: 5.
aleksey@ubuntu-gb:/mnt/d/Git/01_GB/01_GB_Developer/12_JavaCore/seminar/01/HW$
````
