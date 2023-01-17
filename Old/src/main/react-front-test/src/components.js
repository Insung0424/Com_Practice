const createElement = domString => {
  const $temp = document.createElement('template');
  $temp.innerHTML = domString;
  return $temp.content;
};

const fetchData = async url => {
  const res = await fetch(url);
  return res.json();
};

const fetchData1 = async url => {
  const res = await fetch(url).then(response => response.text());
  console.log(res);
  return res;
};

export const Home = async () => {
  const { content } = await fetchData('/api/hello');
  return createElement(`<p>${content}</p>`);
};

export const dynamic = async () => {
  const content = await fetchData1('/get/data');
  return createElement(`<p>${content}</p>`);
};

export const NotFound = () => createElement('<h1>404 NotFound</p>');