package sample.data.live.livedatamvp.models.response;

public class PostResponse
{
    public int userId;
    public int id;
    public String title;
    public String body;

    public PostResponse()
    {

    }

    public PostResponse(int userId, int id, String title, String body)
    {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }
} 
