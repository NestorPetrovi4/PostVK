fun main() {
    val post = Post(1, 2, 3, date =  5, text =  "test", replyOwnerId = 6,comments = Comments(), likes = Likes())
    WallService.add(post)
    WallService.add(post)
    WallService.add(post)
    val post1 = Post(2, 2, 3, date =  5, text =  "test update", replyOwnerId = 6,comments = Comments(), likes = Likes())
    WallService.update(post1)
    println(WallService)
}