# APIUniDocs
## Setup
**1. Clone the application**

```bash
git clone https://github.com/AKhoa2109/BaiTapAPITuan03.git
```
**2. Create Mysql database**
```bash
create database uni_docs
```
**3. Change mysql username and password as per your installation**

+ open `src/main/resources/application.yaml`
+ change `spring.datasource.username` and `spring.datasource.password` as per your mysql installation
+ add environment `EMAIL, PASSWORD, DB_NAME, DB_PASS`

**4. Run the app using maven**

+ The app will start running at <http://localhost:8080>
+ Test swagger at <http://localhost:8080/swagger-ui/index.html>




## API Endpoint
### Users

| Method | Url                                       | Description                                   | Sample Valid Request Body                                                                                         |
|--------|-------------------------------------------|-----------------------------------------------|-------------------------------------------------------------------------------------------------------------------|
| POST   | /api/user/register                        | Đăng ký người dùng mới                        | `{"name": "Tran An","age": 25,"gender": "male","birthday": "1998-05-12","email": "tranan@gmail.com","password": "123"}` |
| POST   | /api/user/login                           | Đăng nhập người dùng                          | `{ "email": "user@gmail.com", "password": "rd123" }`                                                            |
| POST   | /api/user/forgot-password                 | Gửi yêu cầu quên mật khẩu qua email           | `email=user@gmail.com`                                                                                          |
| POST   | /api/user/verify-otp-for-activation       | Xác minh OTP để kích hoạt tài khoản người dùng | `{ "email": "user@gmail.com", "otp": "123456" }`                                                                |
| POST   | /api/user/verify-otp-for-password-reset   | Xác minh OTP để thay đổi mật khẩu người dùng  | `{ "email": "user@gmail.com", "otp": "123456", "newPassword": "123" }`                                            |
### Category
| Method | Url               | Description                  | Sample Valid Request Body                                                                                         |
|--------|-------------------|------------------------------|-------------------------------------------------------------------------------------------------------------------|
| GET    | /api/category/all | Xem tất cả danh mục tài liệu |  |
### Document
| Method | Url                        | Description                                     | Sample Valid Request Body                                                                                         |
|--------|----------------------------|-------------------------------------------------|-------------------------------------------------------------------------------------------------------------------|
| GET    | /api/product/get-product/1 | Hiển thị tất cả sản phẩm theo từng danh mục     |  |
| GET    | /api/product/top-seller    | Hiển thị 10 sản phẩm có số lượng bán nhiều nhất |  |
| GET    | /api/product/top-newest    | Hiển thị 10 sản phẩm được tạo <=7 ngày          |  |


