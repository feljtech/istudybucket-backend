package com.elroykanye.istudybucket.business.mapper;

import com.elroykanye.istudybucket.api.dto.BucketDto;
import com.elroykanye.istudybucket.config.constant.DefaultDto;
import com.elroykanye.istudybucket.config.constant.DefaultEntity;
import com.elroykanye.istudybucket.data.entity.Bucket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BucketMapperTest {
    private final BucketMapper bucketMapper;

    private Bucket bucket;
    private BucketDto bucketDto;

    @Autowired
    public BucketMapperTest(BucketMapper bucketMapper) {
        this.bucketMapper = bucketMapper;
    }

    @BeforeEach
    void setUp() {
        bucket = DefaultEntity.DEFAULT_BUCKET;
        bucketDto = DefaultDto.DEFAULT_BUCKET_DTO;

        bucket.setCreator(DefaultEntity.DEFAULT_USER);
        bucket.setDefaultChatId(DefaultEntity.DEFAULT_CHAT.getId());
    }

    @Test
    void mapBucketToDto() {
        BucketDto bucketDto1 = bucketMapper.mapBucketToDto(bucket);
        assertEquals(bucket.getId(), bucketDto1.getId());
        assertEquals(bucket.getTitle(), bucketDto1.getTitle());
        assertEquals(bucket.getDescription(), bucketDto1.getDescription());
        assertEquals(bucket.getCreatedAt(), bucketDto1.getCreatedAt());
        assertEquals(bucket.getGroupImage(), bucketDto1.getGroupImage());

        assertEquals(bucket.getMemberships().size(), bucketDto1.getMemberCount());
        assertEquals(bucket.getDefaultChatId(), bucketDto1.getDefaultChatId());
        assertEquals(bucket.getCreator().getId(), bucketDto1.getCreatorId());
    }

    @Test
    void mapDtoToBucket() {
        Bucket bucket1 = bucketMapper.mapDtoToBucket(bucketDto);
        assertEquals(bucketDto.getId(), bucket1.getId());
        assertEquals(bucketDto.getTitle(), bucket1.getTitle());
        assertEquals(bucketDto.getDescription(), bucket1.getDescription());
        assertEquals(bucketDto.getGroupImage(), bucket1.getGroupImage());
    }
}
