-- Create comments table
CREATE TABLE IF NOT EXISTS comments (
    comment_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    content VARCHAR(1000) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    content_type VARCHAR(20) NOT NULL,
    content_id BIGINT NOT NULL,
    CONSTRAINT fk_comment_user FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE
);

-- Add indexes for faster lookups
CREATE INDEX idx_comments_content_type_id ON comments(content_type, content_id);
CREATE INDEX idx_comments_user_id ON comments(user_id);
