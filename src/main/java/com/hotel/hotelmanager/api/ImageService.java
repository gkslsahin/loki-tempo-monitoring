package com.hotel.hotelmanager.api;

import com.hotel.hotelmanager.model.ImageDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/images")
public class ImageService {

    @GetMapping("/{hId}")
    public ResponseEntity<List<ImageDTO>> getImages(@PathVariable Long hId) throws InterruptedException {
        Thread.sleep(5000);
        log.info("getImages called -> hotelId: {}", hId);
        List<ImageDTO> imageDTOList = new ArrayList<>();
        Stream.iterate(1, i -> i + 2).limit(30).forEach(i -> ImageDTO.builder().path("path" + i).build());
        return new ResponseEntity<>(imageDTOList, HttpStatus.OK);

        }

    }
