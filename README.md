# insura-demo


# Step Deployment insura-demo
 - buat direktori input pada direktory spring boot App akan di jalankan :
        contoh jika Dideploy di Windows  , Jika  Project akan di deploy di folder C maka buat direktori di C:\input , jika di folder D maka buat di D:\input.
        Jika Di linux , Direktori input dibuat di root folder /input/
 - taruh template siswa.csv and nilai.csv di folder input
 - Default Job aplikasi jalan setiap hari jam 17:01  , Jika ingin dirubah jam dan menit nya rubah   config Cron.expression di folder application properties
 - Build Spring Boot project dengan Maven : 
    > **mvn clean install**
 - Run Spring Boot Project dengan Maven 
    > **mvn spring-boot:run**
 - atau Spring Boot Project dengan Java -jar command
    > **java -jar target/demo-0.0.1-SNAPSHOT**
 - Untuk akses Rest Api bisa menggunakan swagger-ui
    > http://localhost:8087/swagger-ui.html

 

