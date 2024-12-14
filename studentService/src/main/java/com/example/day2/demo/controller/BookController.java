package com.example.day2.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
///api/v1/books -> requestMapping -> api getAll (thì GetMapping ở phía dứoi, ko cần path)
// useEffect gọi api set vào list
///api/v1/books/{id} -> GetMapping (Lấy ra 1 book)
// Detail 1 sản phẩm nào đấy, tức là ở list trên chỉ hiện ra thông tin cơ bản
// Khi click vào thì sẽ hiển thị chi tiết
///api/v1/books/{id} -> DeleteMapping (Xoá 1 book theo id)
// CHo admin quản lý
///api/v1/books{id} + bodyRequest -> PutMapping -> Update book theo id
// Cho admin quản lý
///api/v1/books + bodyRequest -> PutMapping -> Update book theo id trong body

///api/v1/books -> PostMapping -> Tạo mới sách

// Các API trả về response -> thường có statusCode, có thông tin đi kèm

// http://localhost:port/api/v1/books
// http://localhost:1111/api/v1/books -> truy cập vào link này, thì mặc định
public class BookController {

    // có nhiều API

    // Các api không được phép trùng path, và trùng method (POST,PUT,GET,DELETE)
    // 1 là khác method, trùng path
    // 2 là trùng method, khác path
    // Khi thiết kế 1 controller
    // GetAll -> không có path
    // Get 1 -> cần path variable truyền vào, để lấy đích danh 1 book
    // Update -> cần path variable truyền kèm với body request -> pvariable chỉ id của book cần sửa, body quest là thông tin cần sửa
    // Post -> tạo mới -> cần bodyrequest để tạo mới book
    // Delete -> Xoá -> cần mỗi path variable để xoá theo id (tuỳ theo yêu cầu)
    // Optional: Mở rộng, cung cấp api thêm (tuỳ thuộc vào nhu cầu cá nhân)
    @GetMapping// ko cần path
    public ResponseEntity<List<String>> getAllBook() { // tên method trong controller, ko quan trọng
        return ResponseEntity.ok(List.of("ABC", "XYZ"));
        // Code 200: Là ok
        // Code 201 là created -> tạo mới
        // Code 3xx -> Thường dùng trong MVC (JSP + Servlet/ Spring MVC)
        // Code 400 -> Bad Request -> Thông tin truyền ở request có vấn đề
        // Code 401 -> Unauthentication -> Không có quyền truy cập vào hệ thống
        // Code 403 -> Unauthorized -> Có account vào hệ thống, hoặc thông tin được vào hệ thống, nhưng mà chưa đủ quyền cao hơn
        // để access vào resource này
        // Code 404 -> Not found,
        // Code 5xx -> Code liên quan đến lỗi hệ thống (hạn chế tối đa, không được phép để lỗi này ra ngoài)
    }
}
