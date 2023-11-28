data class Post(
    val id: Int,
    var ownerId: Int,
    var fromId: Int,
    var createdBy: Int = 0,
    var date: Int,
    var text: String,
    var replyOwnerId: Int,
    var friendsOnly: Boolean = false,
    var comments: Comments,
    var likes: Likes? = null,
    var attachments: Array<Attachments>? = null
)

class Comments(
    val count: Int = 0,
    var canPost: Boolean = true,
    var groupsCanPost: Boolean = true,
    var canClose: Boolean = true,
    var canOpen: Boolean = false
)

class Likes(
    val count: Int = 0,
    var userLikes: Boolean = false,
    var canLike: Boolean = true,
    var canPublish: Boolean = true
)

object WallService {
    private var posts = emptyArray<Post>()
    private var lastId: Int = 0

    fun add(post: Post): Post {
        lastId += 1
        val newPost = post.copy(id = lastId)
        posts += newPost
        return newPost
    }

    fun update(post: Post): Boolean {
        for ((index, postReal) in posts.withIndex()) {
            if (postReal.id == post.id) {
                posts[index] = post.copy()
                return true
            }
        }
        return false
    }

    fun clear() {
        posts = emptyArray<Post>()
        lastId = 0
    }

    override fun toString(): String {
        return "WallService(posts=${posts.contentToString()})"
    }

}