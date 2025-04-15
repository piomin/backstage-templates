using System.ComponentModel.DataAnnotations.Schema;

namespace app.Model
{
    [Table("persons")]
    public class Person
    {
        [System.ComponentModel.DataAnnotations.Key]
        [Column("id")] 
        public int Id { get; set; }

        [Column("name")] 
        public string Name { get; set; }

        [Column("age")] 
        public int Age { get; set; }
    }
}